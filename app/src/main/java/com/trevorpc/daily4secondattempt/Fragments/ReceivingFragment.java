package com.trevorpc.daily4secondattempt.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trevorpc.daily4secondattempt.MessagesReceivedAdapter;
import com.trevorpc.daily4secondattempt.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReceivingFragment extends Fragment {
    public static final String RECV_FRAG_TAG = "sending_frag";
    TextView tvMessageReceived;
    RecyclerView rvMessagesReceived;
    MessagesReceivedAdapter adapter;

    ArrayList<String> messagesRecivedList = new ArrayList<>();

    public ReceivingFragment() {
        // Required empty public constructor
    }

    public static ReceivingFragment newInstance() {
        ReceivingFragment receivingFragment = new ReceivingFragment();

        return receivingFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recieving, container, false);
        messagesRecivedList.add("MESSAGES");
        rvMessagesReceived = view.findViewById(R.id.rvMessagesReceived);
        adapter = new MessagesReceivedAdapter(messagesRecivedList, this.getContext());
        rvMessagesReceived.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvMessagesReceived.setAdapter(adapter);

        return view;
    }

    public void receiveMessage(String msgReceived) {
        adapter.getNewMsg(msgReceived);
    }

    public interface OnFragmentInteractionListener{
        void sendMessageToMainActivity(String messageToSend);
    }


}
