package com.gamestudio.finalexp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserLayoutAdapter extends RecyclerView.Adapter<UserLayoutAdapter.Viewholder> {

    private Context context;
    private ArrayList<UserRecordModel> userRecordModelArrayList;

    // Constructor
    public UserLayoutAdapter(Context context, ArrayList<UserRecordModel> userRecordModelArrayList) {
        this.context = context;
        this.userRecordModelArrayList = userRecordModelArrayList;
    }

    @NonNull
    @Override
    public UserLayoutAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_record_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserLayoutAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        UserRecordModel model = userRecordModelArrayList.get(position);

        holder.id.setText(model.getId());
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.gender.setText(model.getGender());
        holder.status.setText(model.getStatus());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return userRecordModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView id, name, email, gender, status;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            gender = itemView.findViewById(R.id.gender);
            status = itemView.findViewById(R.id.status);
        }
    }
}