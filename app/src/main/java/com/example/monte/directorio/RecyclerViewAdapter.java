package com.example.monte.directorio;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Contacts> data;
    Dialog dialog;

    public RecyclerViewAdapter(Context context, List<Contacts> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(context).inflate(R.layout.contact_tags, parent, false);
        final ViewHolder vHolder = new ViewHolder(v);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.caja_contacto);

        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_tv = (TextView) dialog.findViewById(R.id.changename);
                TextView dialog_phone = (TextView) dialog.findViewById(R.id.changenumber);
                ImageView dialog_photo = (ImageView) dialog.findViewById(R.id.photo);
                dialog_tv.setText(data.get(vHolder.getAdapterPosition()).getName());
                dialog_phone.setText(data.get(vHolder.getAdapterPosition()).getPhone());
                dialog_photo.setImageResource(data.get(vHolder.getAdapterPosition()).getPhoto());
                dialog.show();
            }

        });

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
        private LinearLayout item_contact;

        public ViewHolder(View itemView) {
            super(itemView);

            textviewName = (TextView) itemView.findViewById(R.id.contactID);
            textviewPhone = (TextView) itemView.findViewById(R.id.contactNumber);
            img = (ImageView) itemView.findViewById(R.id.person);
            item_contact = (LinearLayout) itemView.findViewById(R.id.contact_item_id);

        }
    }
}
