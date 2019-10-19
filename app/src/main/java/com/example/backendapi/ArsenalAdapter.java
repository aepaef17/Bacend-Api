package com.example.backendapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArsenalAdapter extends RecyclerView.Adapter<ArsenalAdapter.ViewHolder> {

    //melakukan pendataan yang dibutuhkan untuk adapter
    private Context context;
    private ArrayList<Arsenal> arsenals;
    private OnClickListener listener;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    //jangan terlebih dahulu membuat constructur untuk arsenals

    public ArsenalAdapter(Context context) {
        this.context = context;
        //berkan data dengan tempat array list kosong karena data diambil dari internet
        this.arsenals = new ArrayList<>();
    }

    //buat sebuah setter untuk arnelas
    public void setArsenals(ArrayList<Arsenal> arsenals) {
        this.arsenals = arsenals;
        //disini terjadi perubahan data sehingga gunakan notifyDataSetChanged
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflater untuk membuat sebuah java object view
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_arsenal_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Arsenal currentArsenal = arsenals.get(position);
        holder.tvName.setText(currentArsenal.getName());
        Picasso.get().load(currentArsenal.getImagePath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arsenals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //lakukan pengkondisian
                    if (listener != null){
                        listener.aksiKlik(getAdapterPosition());
                    }
                }
            });
        }
    }
}
