package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

/**
 * Created by Suraj on 28-02-2016.
 */
public class BaseFragment extends Fragment {

    Button mTellJokeButton;
    ProgressBar mSpinner;
    private MyApi mApiService=null;

    public BaseFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_main, container, false);
        mSpinner=(ProgressBar)root.findViewById(R.id.progressBar);
        mSpinner.setVisibility(View.GONE);
        mTellJokeButton=(Button)root.findViewById(R.id.telljokeButton);

        mTellJokeButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke(){
        new EndPointsAsycTask(getActivity(), mSpinner, false).execute("give me the joke");
    }
}
