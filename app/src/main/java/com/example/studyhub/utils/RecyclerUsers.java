package com.example.studyhub.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.studyhub.R;
import com.example.studyhub.activities.ViewOtherProfileActivity;
import com.example.studyhub.data.User;

import java.util.List;

public class RecyclerUsers extends RecyclerView.Adapter<RecyclerUsers.ViewHolder> {
    private List<User> userList;
    private Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final ImageView viewProfileBtn;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            name = view.findViewById(R.id.outputBuddyListName);
            viewProfileBtn = view.findViewById(R.id.buddyViewProfileBtn);
        }

        public TextView getName() {
            return name;
        }

        public ImageView getViewProfileBtn() {
            return viewProfileBtn;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public RecyclerUsers(Context context, List<User> dataSet) {
        this.context = context;
        userList = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycleview_card_small, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        User user = userList.get(position);
        viewHolder.getName().setText(user.getFullName());
        viewHolder.getViewProfileBtn().setOnClickListener(v -> {
            Intent intent = new Intent(context, ViewOtherProfileActivity.class);
            intent.putExtra("id", user.getId());
            context.startActivity(intent);
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return userList.size();
    }
}
