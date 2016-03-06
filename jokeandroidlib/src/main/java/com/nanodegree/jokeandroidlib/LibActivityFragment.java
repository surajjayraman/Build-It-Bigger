package com.nanodegree.jokeandroidlib;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Suraj on 28-02-2016.
 */
public class LibActivityFragment extends Fragment {
    public LibActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_lib, container, false);

        Intent intent=getActivity().getIntent();
        String joke=intent.getStringExtra(LibActivity.JOKE_INTENT_EXTRA);

        TextView textView=(TextView) root.findViewById(R.id.jokeContentTextView);
        textView.setText(joke);

        return root;
    }
}