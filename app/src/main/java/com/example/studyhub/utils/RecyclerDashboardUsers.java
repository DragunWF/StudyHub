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
import com.example.studyhub.data.User;

import java.util.List;

public class RecyclerDashboardUsers extends RecyclerView.Adapter<RecyclerDashboardUsers.ViewHolder> {

    private List<User> userList;
    private Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView course;
        private TextView accType;
        private ImageView viewProfileBtn;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            name = view.findViewById(R.id.dashboardName);
            course = view.findViewById(R.id.dashboardCourse);
            accType = view.findViewById(R.id.dashboardAccType);
            viewProfileBtn = view.findViewById(R.id.viewProfileBtn);
        }

        public TextView getName() {
            return name;
        }

        public TextView getCourse() {
            return course;
        }

        public TextView getAccType() {
            return accType;
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
    public RecyclerDashboardUsers(Context context, List<User> dataSet) {
        this.context = context;
        userList = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycleview_card, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        User user = userList.get(position);
        viewHolder.getName().setText(String.format("Name: %s %s", user.getFirstName(), user.getLastName()));
        viewHolder.getCourse().setText("Course: " + user.getCourse());
        viewHolder.getAccType().setText("Acc. Type: " + user.getUserType());
        viewHolder.getViewProfileBtn().setOnClickListener(v -> {
            // Intent intent = new Intent(context, ViewProfileActivity.class);
            // intent.putExtra("id", user.getId());
            // context.startActivity(intent);
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return userList.size();
    }
}
