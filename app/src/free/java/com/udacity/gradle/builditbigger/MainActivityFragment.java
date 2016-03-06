package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * Created by Suraj on 28-02-2016.
 */


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    InterstitialAd mInterstitialAd;
    AdView mAdView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = super.onCreateView(inflater, container, savedInstanceState);

        mAdView = (AdView) root.findViewById(R.id.adView);

        // Create an ad request
        mAdView.loadAd(buildTestAdRequest());

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-8851761175252738/9317429242");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                tellJoke();
            }
        });

        requestNewInterstitial();

        mTellJokeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mSpinner.setVisibility(View.VISIBLE);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    tellJoke();
                }
            }
        });

        return root;
    }

    private AdRequest buildTestAdRequest() {
        return new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
    }

    private void requestNewInterstitial() {
        mInterstitialAd.loadAd(buildTestAdRequest());
    }
}





























