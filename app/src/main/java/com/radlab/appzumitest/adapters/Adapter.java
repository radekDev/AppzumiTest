package com.radlab.appzumitest.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.radlab.appzumitest.R;
import com.radlab.appzumitest.network.models.AdapterItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<AdapterItem> _values;
    private AdapterInterface _adapterInterface;
    private Context _context;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.text1)
        TextView text1;
        @BindView(R.id.text2)
        TextView text2;
        @BindView(R.id.text3)
        TextView text3;
        @BindView(R.id.card_view)
        CardView cardView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public Adapter(List<AdapterItem> values, Context context) {
        _values = values;
        _context = context;
        try {
            _adapterInterface = (AdapterInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("context must implement AdapterInterface");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.text1.setText(_values.get(position).getRepoName());
        holder.text2.setText( _values.get(position).getUserName());
        Picasso.get().load( _values.get(position).getAvatarUrl()).into(holder.avatar);
        holder.text3.setText( _values.get(position).getRepoDesc());
        setAccent(holder, _values.get(position).isBitbucket());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _adapterInterface.showDetails(_values.get(position));
            }
        });

        Picasso.get().load( _values.get(position).getAvatarUrl()).into(holder.avatar);
    }

    private void setAccent(ViewHolder holder, boolean isBitBucket){
        if(isBitBucket){
            holder.text1.setTextColor(Color.RED);
        }else {
            holder.text1.setTextColor(holder.text2.getTextColors());
        }
    }

    @Override
    public int getItemCount() {
        return _values.size();
    }
}