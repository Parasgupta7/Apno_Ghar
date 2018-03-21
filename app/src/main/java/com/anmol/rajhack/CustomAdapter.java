package com.anmol.rajhack;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by anmol on 1/12/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {



    private Context context;
    private List<MyData> my_data;



    public CustomAdapter(Context context, List<MyData> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){



        holder.Title.setText(my_data.get(position).getTitle());
        Picasso.with(context).load(my_data.get(position).getImage()).into(holder.Image);

        holder.Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),DynamicFragment.class);
                intent.putExtra("id",my_data.get(position).getId());
                intent.putExtra("title",my_data.get(position).getTitle());
                view.getContext().startActivity(intent);
                Toast.makeText(view.getContext(),""+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
        /*holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"clicked at"+holder.getAdapterPosition(),Toast.LENGTH_LONG).show();

                if(my_data.get(position).getId()==(int)my_data.get(position).getId()){
                    Toast.makeText(view.getContext(),"clicked at"+holder.getAdapterPosition(), Toast.LENGTH_LONG).show();
                    Intent i = new Intent(view.getContext(),Aditi.class);
                    i.putExtra("desc",my_data.get(position).getDescription());
                    view.getContext().startActivity(i);

                }
            }
        });*/




    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{


        public ImageView Image;
        public TextView Title;


        public ViewHolder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.title);
           
            Image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
