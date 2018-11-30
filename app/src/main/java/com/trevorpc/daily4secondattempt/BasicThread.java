package com.trevorpc.daily4secondattempt;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import android.widget.EditText;
import android.widget.TextView;



import java.util.HashMap;


public class BasicThread extends Thread
{

    Handler threadHandler = new Handler(Looper.getMainLooper());

    HashMap<String,Integer> map = new HashMap<>();
    String name = "Adam the Nomad";
    TextView tvInvisibleLetter;
    EditText etInput;
    private int leaderNum=1;
    String leader="Error";



    public BasicThread(EditText etInput,TextView tvInvisibleLetter) {
        this.etInput = etInput;
        this.tvInvisibleLetter = tvInvisibleLetter;

    }

    @Override
    public void run() {
        Log.d("TAG", "run: ");
        super.run();
        name = etInput.getText().toString();
        name = name.toUpperCase();
        name = name.replaceAll(" ", "");
        Log.d("TAG", "run: " + name);

        for (int x = 0; x < name.length(); x++) {
            String temp = Character.toString(name.charAt(x));
            if (map.containsKey(temp)) {
                Integer y = map.get(temp);
                y = y + 1;
                map.remove(temp);
                map.put(temp, y);
            } else {
                map.put(temp, 1);
            }

            if (map.get(temp) > leaderNum) {
                leaderNum = map.get(temp);
                leader = temp;
            }

            tvInvisibleLetter.setText(leader);


        }

    }



}