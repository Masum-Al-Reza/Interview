package com.example.interview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interview.R;
import com.example.interview.pojos.Photos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.Recyclerviewholder> {
    private Context context;
    private List<Photos> list;

    public Recyclerviewadapter(Context context, List<Photos> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Recyclerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.album_rows,parent,false);

        return new Recyclerviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerviewholder holder, int position) {
        holder.albmtitle.setText("Title  :"+list.get(position).getTvtitle());
        holder.albumid.setText("Album id :"+list.get(position).getAlbumid());
        holder.id.setText("id :"+list.get(position).getId());
        Picasso.get().load(list.get(position).getFullurl()).into(holder.albumimage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Recyclerviewholder extends RecyclerView.ViewHolder{
     TextView albmtitle,albumid,id;
     ImageView albumimage;
        public Recyclerviewholder(@NonNull View itemView) {
            super(itemView);
          albmtitle=itemView.findViewById(R.id.titleTV);
          albumid=itemView.findViewById(R.id.albumidTV);
          id=itemView.findViewById(R.id.idTV);
          albumimage=itemView.findViewById(R.id.imageALBM);
        }
    }
}
