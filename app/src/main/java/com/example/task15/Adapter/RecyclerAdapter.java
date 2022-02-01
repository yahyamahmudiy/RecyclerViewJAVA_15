package com.example.task15.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.task15.Activity.MainActivity;
import com.example.task15.Model.Member;
import com.example.task15.R;
import java.util.ArrayList;
import java.util.Collections;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    MainActivity activity;
    ArrayList<Member> members;

    public RecyclerAdapter(MainActivity activity, ArrayList<Member> members){
        this.activity = activity;
        this.members = members;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         Member member = members.get(position);

        if(holder instanceof MemberViewHolder){

            ImageView iv_profile = ((MemberViewHolder)holder).iv_profile;
            TextView tv_name = ((MemberViewHolder)holder).tv_name;
            TextView tv_surname = ((MemberViewHolder)holder).tv_surname;

            iv_profile.setImageResource(member.getProfile());
            tv_name.setText(member.getName());
            tv_surname.setText(member.getSurname());

        }
    }

    public void removeItem(int position){
        members.remove(position);
        notifyItemRemoved(position);
    }
    public void restoreItem(Member member,int position){
        members.add(position,member);
        notifyItemInserted(position);
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView iv_profile;
        public TextView tv_name;
        public TextView tv_surname;
        public LinearLayout view_foreground,view_background;

        public MemberViewHolder(View v){
            super(v);
            this.view = v;

            iv_profile = view.findViewById(R.id.iv_profile);
            tv_name = view.findViewById(R.id.tv_name);
            tv_surname = view.findViewById(R.id.tv_surname);

            view_foreground = view.findViewById(R.id.view_foreground);
            view_background = view.findViewById(R.id.view_background);
        }
    }
}