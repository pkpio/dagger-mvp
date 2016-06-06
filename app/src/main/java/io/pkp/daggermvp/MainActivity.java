package io.pkp.daggermvp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import javax.inject.Inject;

import io.pkp.daggermvp.models.Repository;
import io.pkp.daggermvp.network.interfaces.GitHubApiInterface;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    Retrofit mRetrofit;

    @Inject
    GitHubApiInterface mGitHubApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Call<ArrayList<Repository>> call = mGitHubApiInterface.getRepository("codepath");

                call.enqueue(new Callback<ArrayList<Repository>>() {
                    @Override
                    public void onResponse(Response<ArrayList<Repository>> response, Retrofit retrofit) {
                        if (response.isSuccess()) {
                            Log.i("DEBUG", response.body().toString());
                            Snackbar.make(view,"Data retrieved", Snackbar.LENGTH_LONG)
                                    .setAction("Action",null).show();
                        } else {
                            Log.i("ERROR", String.valueOf(response.code()));
                        }

                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }

        });

        ((MyApp) getApplication()).getGitHubComponent().inject(this);
    }

}
