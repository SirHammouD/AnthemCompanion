package com.project.hammy.anthemcompanion;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;


import java.util.ArrayList;
import java.util.List;

class MyViewHolderWithoutChild extends RecyclerView.ViewHolder  {

    public MyViewHolderWithoutChild(View itemView) {
        super(itemView);
    }
}

class MyViewHolderWithChild extends RecyclerView.ViewHolder{
    public TextView title,text;
    public ImageView image;
    public RelativeLayout button;
    public ExpandableLinearLayout expandableLayout;

    public MyViewHolderWithChild(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        image = (ImageView) itemView.findViewById(R.id.image);
        text = (TextView) itemView.findViewById(R.id.text);
        button = (RelativeLayout) itemView.findViewById(R.id.button);
        expandableLayout = (ExpandableLinearLayout) itemView.findViewById(R.id.expandableLayout);

    }
}

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

List<Weapons> items;
Context context;
SparseBooleanArray expandSate = new SparseBooleanArray();


    public RecyclerAdapter(List<Weapons> items) {
        this.items = items;
        for (int i=0; i< items.size();i++ ){
            expandSate.append(i,false);

        }
    }

    @Override
    public int getItemViewType(int position) {
       if (items.get(position).isExpandable())
           return 1;

        else

           return 0;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       this.context= parent.getContext();
       if (viewType==0){
           LayoutInflater inflater = LayoutInflater.from(context);
           View view =inflater.inflate(R.layout.weapons_item,parent,false);
           return new MyViewHolderWithoutChild(view);
       }
       else {
           LayoutInflater inflater = LayoutInflater.from(context);
           View view =inflater.inflate(R.layout.weapons_item,parent,false);
           return new MyViewHolderWithChild(view);
       }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    switch (holder.getItemViewType()){


        case 1:
        {
            final MyViewHolderWithChild viewHolder = (MyViewHolderWithChild)holder;
            Weapons item = items.get(position);
            viewHolder.setIsRecyclable(false);

            viewHolder.title.setText(item.getName());
            viewHolder.expandableLayout.setInRecyclerView(true);
            viewHolder.expandableLayout.setExpanded(expandSate.get(position));
            viewHolder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
                @Override
                public void onAnimationStart() {

                }

                @Override
                public void onAnimationEnd() {

                }

                @Override
                public void onPreOpen() {

                    expandSate.put(position,true);
                }

                @Override
                public void onPreClose() {

                    expandSate.put(position,false);

                }

                @Override
                public void onOpened() {

                }

                @Override
                public void onClosed() {

                }
            });
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.expandableLayout.toggle();
                }
            });
            viewHolder.text.setText(items.get(position).getText());
            viewHolder.image.setImageResource (items.get(position).getImageUrl());
        }
        break;
        default:
            break;
    }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




}
