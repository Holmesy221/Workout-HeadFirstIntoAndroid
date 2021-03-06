package holmes.holmesy.workout;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;


    public StopwatchFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_stopwatch,container,false);
        runTimer(view);
        return view;
    }

    @Override
    public void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume(){
        super.onResume();
        if (wasRunning){
            running = true;
        }
    }

@Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
}


public void onClickStart(View view){
        running = true;
}

public void onClickStop(View view){
        running = false;
}

public void onClickReset(View view){
        running = false;
        seconds = 0;
}

private void runTimer(View view){
        final TextView timeView = view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours,minutes,secs);
                timeView.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }




}
