package com.radlab.appzumitest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.radlab.appzumitest.adapters.Adapter;
import com.radlab.appzumitest.adapters.AdapterInterface;
import com.radlab.appzumitest.mvp.MainView;
import com.radlab.appzumitest.mvp.Presenter;
import com.radlab.appzumitest.mvp.PresenterImpl;
import com.radlab.appzumitest.network.Services;
import com.radlab.appzumitest.network.models.AdapterItem;
import com.radlab.appzumitest.network.response.bitbucket.BitbucketResponse;
import com.radlab.appzumitest.network.response.github.GithubResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements MainView, AdapterInterface {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.content_main)
    RelativeLayout contentMain;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.text)
    TextView textView;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    private Presenter _presenter;
    private Call<List<GithubResponse>> _githubCall;
    private Call<BitbucketResponse> _bitbucketCall;

    private Callback<List<GithubResponse>> _githubResponseCallback = new Callback<List<GithubResponse>>() {
        @Override
        public void onResponse(Response<List<GithubResponse>> response, Retrofit retrofit) {
            if (response != null) {
                _presenter.onGithubDataReceive(response.body());
                _bitbucketCall.enqueue(_bitbucketResponseCallback);
            } else {
                Snackbar.make(coordinatorLayout, response.raw().message(), Snackbar.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Throwable t) {
            if (t instanceof IOException) {
                Snackbar.make(coordinatorLayout, "network connection error", Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(coordinatorLayout, "unknown connection error", Snackbar.LENGTH_LONG).show();
            }
        }
    };

    private Callback<BitbucketResponse> _bitbucketResponseCallback = new Callback<BitbucketResponse>() {
        @Override
        public void onResponse(Response<BitbucketResponse> response, Retrofit retrofit) {
            if (response != null) {
                _presenter.onBitbucketDataReceive(response.body());
            } else {
                Snackbar.make(coordinatorLayout, response.raw().message(), Snackbar.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Throwable t) {
            if (t instanceof IOException) {
                Snackbar.make(coordinatorLayout, "network connection error", Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(coordinatorLayout, "unknown connection error", Snackbar.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRetrofit();
        initView();
        _presenter = new PresenterImpl(this);
        _presenter.collectData();
    }

    private void initRetrofit() {
        Retrofit githubRetrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.GITHUB_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Services _gitHubServices = githubRetrofit.create(Services.class);

        Retrofit bitbucketbRetrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.BITBUCKET_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Services _bitbucketServices = bitbucketbRetrofit.create(Services.class);

        _githubCall = _gitHubServices.getGitHubData();
        _bitbucketCall = _bitbucketServices.getBitbucketData();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(null);
    }

    @Override
    protected void onDestroy() {
        _presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void sendRequest() {
        _githubCall.enqueue(_githubResponseCallback);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setAdapter(ArrayList<AdapterItem> adapterItems) {
        Adapter _adapter = new Adapter(adapterItems, this);
        recyclerView.setAdapter(_adapter);
    }

    @Override
    public void showDetails(AdapterItem adapterItem) {
        Intent intent = new Intent(getBaseContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.KEY, adapterItem);
        startActivity(intent);
    }
}
