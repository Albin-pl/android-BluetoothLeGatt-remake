package com.example.android.bluetoothlegatt;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Albin on 2017-05-04.
 */

public class ProgressBarActivity extends DeviceControlActivity {

    private int pint1, pint2;

    @BindView(R.id.textView1)
    TextView tv1;

    @BindView(R.id.textView2)
    TextView tv2;



    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar);


        //addMessageToAdapter("");


        Button btnClose = (Button) findViewById(R.id.buttonClose);

        // Binding Click event to Button
        btnClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Closing DeviceList Activity
                finish();
            }
        });

    }

    private void addMessageToAdapter(String chatMessage) {
        String str = chatMessage;
        String[] parts = str.split("[:,,,]");

        ProgressBar pb1 = (ProgressBar) findViewById(R.id.progressBar1);
        ProgressBar pb2 = (ProgressBar) findViewById(R.id.progressBar2);

        if (parts[0].equals("ADC")) {

            pint1 = Integer.parseInt(parts[1]);
            pint2 = Integer.parseInt(parts[2]);

            tv1.setText("ADC 1:     " + pint1);
            tv2.setText("ADC 2:     " + pint2);



            pb1.setProgress(pint1);
            pb1.getProgressDrawable().setColorFilter(
                    makeColor(pint1, pb1.getMax()), android.graphics.PorterDuff.Mode.SRC_IN);


            pb2.setProgress(pint2);
            pb2.getProgressDrawable().setColorFilter(
                    makeColor(pint2, pb2.getMax()), android.graphics.PorterDuff.Mode.SRC_IN);



        }
    }

    private Integer makeColor(double progress, double max){
        double percent = Math.round(progress/max*100);
        double green, red;

        if (percent <= 50 ) {
            green = 255;
            red = Math.round(percent*255/100);
            if (red > 255) red = 255;
        } else {
            red = 255;
            green = 256-Math.round(percent*255/100);
            if (green == 254) green = 255;
        }
        return Color.argb(255, (int)red, (int)green, 000);
    }

}
