package id.co.asyst.gabriella.louisa.recyclerviewlogin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.co.asyst.gabriella.louisa.recyclerviewlogin.R;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.Task;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.utility.DateUtils;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Task> mListTask;

    public TaskAdapter(Context context, ArrayList<Task> listTask) {
        this.mContext = context;
        this.mListTask = listTask;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ivItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskAdapter.MyViewHolder(ivItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Task task = mListTask.get(position);
        holder.tvname.setText(task.getName());
        holder.tvAddress.setText(task.getAddress());
        holder.tvSerialNumber.setText("#" + task.getSerialNumber());
        holder.tvId.setText("   " + task.getId() + "   ");
        holder.tvStartDate.setText(DateUtils.formatDate("yyyy-MM-dd", "dd MMMM yyyy", task.getStartDate()));
        if (task.getFinishDate() == null) {
            holder.tvFinishDate.setText("-");
        } else {
            holder.tvFinishDate.setText("Selesai pada " + DateUtils.formatDate("yyyy-MM-dd", "dd MMMM yyyy", task.getFinishDate()));
        }
//        holder.tvFinishDate.setText(DateUtils.formatDate("yyyy-MM-dd", "dd MMMM yyyy",task.getFinishDate()));
//        holder.tvStartDate.setText(task.getStartDate());
//        holder.tvFinishDate.setText(task.getStartDate());
    }

    @Override
    public int getItemCount() {
        return mListTask.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvname, tvAddress, tvSerialNumber, tvStartDate, tvFinishDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.textViewId);
            tvname = itemView.findViewById(R.id.textViewName);
            tvAddress = itemView.findViewById(R.id.textViewAddress);
            tvSerialNumber = itemView.findViewById(R.id.textViewNomer);
            tvStartDate = itemView.findViewById(R.id.textViewDate);
            tvFinishDate = itemView.findViewById(R.id.textViewFinishDate);
        }
    }
}
