package com.trevorpc.daily4secondattempt.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trevorpc.daily4secondattempt.BasicThread;
import com.trevorpc.daily4secondattempt.MessagesReceivedAdapter;
import com.trevorpc.daily4secondattempt.R;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendingFragment extends Fragment implements View.OnClickListener{
    public static final String SEND_FRAG_TAG = "sending_frag";

    EditText etMessageToSend;
    Button btnSendMessage;
    Button btnWordCount;
    OnFragmentInteractionListener mListener;
    TextView tvInvisibleLetter;


    public static SendingFragment newInstance() {
        SendingFragment fragment = new SendingFragment();
        return fragment;
    }

    public SendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sending, container, false);
        etMessageToSend = view.findViewById(R.id.etMessageToSend);
        tvInvisibleLetter = view.findViewById(R.id.tvInvisibleLetter);
        btnSendMessage = view.findViewById(R.id.btnSendMessage);
        btnWordCount = view.findViewById(R.id.btnWordCount);
        btnSendMessage.setOnClickListener(this);
        btnWordCount.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {

            case R.id.btnSendMessage:

                Log.d("TAG", "Sending ");
                String messageToSend = etMessageToSend.getText().toString();
                mListener.sendMessageToMainActivity(messageToSend.isEmpty() ? "EMPTY" : messageToSend);
                break;

            case R.id.btnWordCount:

                Log.d("TAG", "onClick: wordCount");
                Analysis(view);

                break;
        }

    }

    public void Analysis(View view) /*throws InterruptedException */ {


        // move to thread
        BasicThread testThreads = new BasicThread(etMessageToSend,tvInvisibleLetter);
        testThreads.start();
        //Thread.sleep(10);
        //  TODO: figure out why exception doesn't work in fragment



        String answer = "The most Common Letter is..."+  tvInvisibleLetter.getText().toString();
        tvInvisibleLetter.setText(answer);
        Toast toast = Toast.makeText(getContext(), answer, Toast.LENGTH_SHORT);
        toast.show();




    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener{
        void sendMessageToMainActivity(String messageToSend);
    }

}
