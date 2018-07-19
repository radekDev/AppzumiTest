package com.radlab.appzumitest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.radlab.appzumitest.network.models.AdapterItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends Activity {

    public static final String KEY = "EXTRA_DETAILS";

    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.text2)
    TextView text2;
    @BindView(R.id.text3)
    TextView text3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_row);
        ButterKnife.bind(this);
        AdapterItem item = (AdapterItem) getIntent().getSerializableExtra(KEY);

        text1.setText(item.getRepoName());
        text2.setText(item.getUserName());
        Picasso.get().load(item.getAvatarUrl()).into(avatar);
        text3.setText(item.getRepoDesc());

    }
}
