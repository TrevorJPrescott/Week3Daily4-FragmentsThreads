package com.trevorpc.daily4secondattempt;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.trevorpc.daily4secondattempt.Fragments.ReceivingFragment;
import com.trevorpc.daily4secondattempt.Fragments.SendingFragment;

public class MainActivity extends AppCompatActivity implements SendingFragment.OnFragmentInteractionListener {
    FragmentManager fragmentManager;
    ReceivingFragment receivingFragment;
    SendingFragment sendingFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receivingFragment = ReceivingFragment.newInstance();
        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
        .add(R.id.sendingFrag,
        SendingFragment.newInstance(), SendingFragment.SEND_FRAG_TAG)
        .addToBackStack(SendingFragment.SEND_FRAG_TAG)
        .commit();

        fragmentManager.beginTransaction()
        .add(R.id.receivingFrag,
        receivingFragment, ReceivingFragment.RECV_FRAG_TAG)
        .addToBackStack(ReceivingFragment.RECV_FRAG_TAG)
        .commit();
    }

    @Override
    public void sendMessageToMainActivity(String messageToSend) {
        receivingFragment.receiveMessage(messageToSend);

    }
}
