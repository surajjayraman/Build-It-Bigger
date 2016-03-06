package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.nanodegree.jokeandroidlib.LibActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Suraj on 28-02-2016.
 */
public class EndPointsAsycTask extends AsyncTask<String, Void, String> {

    private static MyApi mMyApiService = null;
    private ProgressBar mSpinner;
    private Context mContext;
    private boolean mTestMode;

    public EndPointsAsycTask(Context context, ProgressBar spinner, boolean testMode) {
        this.mContext = context;
        this.mSpinner = spinner;
        this.mTestMode = testMode;
    }

    private MyApi getApiService() {
        if (mMyApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(mContext.getString(R.string.gceendpoint));

            if (!builder.getRootUrl().startsWith("https:"))
                builder.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                        request.setDisableGZipContent(true);
                    }
                });

            mMyApiService = builder.build();
        }
        return mMyApiService;
    }

    @Override
    protected void onPreExecute() {
        if (!mTestMode)
            mSpinner.setVisibility(View.VISIBLE);
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        String which = strings[0];
        try {
            return getApiService().getAJoke(which).execute().getData();
        } catch (IOException e) {
            return "EXCEPTION: " + e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (!mTestMode) {
            mSpinner.setVisibility(View.GONE);

            Intent intent = new Intent(mContext, LibActivity.class);
            intent.putExtra(LibActivity.JOKE_INTENT_EXTRA, result);
            mContext.startActivity(intent);
        }
    }


}
