package com.example.monte.directorio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Contacts> data;

    public RecyclerViewAdapter(Context context, List<Contacts> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(context).inflate(R.layout.contact_tags, parent, false);
        ViewHolder vHolder = new ViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textviewName.setText(data.get(position).getName());
        holder.textviewPhone.setText(data.get(position).getPhone());
        holder.img.setImageResource(data.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textviewName;
        private TextView textviewPhone;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            textviewName = (TextView) itemView.findViewById(R.id.contactID);
            textviewPhone = (TextView) itemView.findViewById(R.id.contactNumber);
            img = (ImageView) itemView.findViewById(R.id.person);

        }
    }
}
