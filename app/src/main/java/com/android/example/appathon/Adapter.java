package com.android.example.appathon;

/**
 * Created by Raju Kaushik on 9/11/2016.
 */
import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.PostViewHolder> {

    private static int Selected;
    Context context;


    ArrayList<PostModel> PostList;
    ArrayList<View> itemsViews;
    DrawerLayout drawerLayout;

    public static Adapter bInstance;
    private static Adapter mInstance;

    public Adapter(Context context,DrawerLayout drawerLayout){

        this.context=context;
        PostList=new ArrayList<>();
        itemsViews= new ArrayList<>();
        bInstance=this;
        this.drawerLayout=drawerLayout;
        //  this.groupsList=list;
    }



    public Adapter(Context context){

        this.context=context;

    }

    public static Adapter getbInstance(Context c){
        if(mInstance==null){
            mInstance = new Adapter(c);
        }
        return mInstance;
    }

    public static Adapter getInstance(Context context){
        if(bInstance==null){
            Selected=1;
            bInstance= new Adapter(context);
        }
        return bInstance;
    }

    public void setPostsList(ArrayList<PostModel> glist){
        this.PostList=glist;
    }


    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView post_name;
        TextView post_text;
        TextView user_name;

        View view;
        public PostViewHolder(View itemView) {
            super(itemView);
            //  Log.e("ABC viewHolder","called ");
            post_name=(TextView) itemView.findViewById(R.id.post_name);
            post_text=(TextView) itemView.findViewById(R.id.post_text);
            user_name=(TextView) itemView.findViewById(R.id.user_name);



        }


    }

    @Override
    public Adapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //  Log.e("ABC create ViewHolder", "called ");
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.post_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {



        holder.post_name.setText(PostList.get(position).post_name);
        holder.post_text.setText(PostList.get(position).post_text);
        holder.user_name.setText(PostList.get(position).user_name);
        itemsViews.add(position,holder.view);
        //Log.e("ABC binder", "called >"+ position);
    }

    @Override
    public int getItemCount() {
        return  PostList.size();


    }

}