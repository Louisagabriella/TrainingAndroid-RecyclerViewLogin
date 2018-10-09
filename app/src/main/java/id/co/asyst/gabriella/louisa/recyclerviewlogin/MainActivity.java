package id.co.asyst.gabriella.louisa.recyclerviewlogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import id.co.asyst.gabriella.louisa.recyclerviewlogin.adapter.TaskAdapter;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.Login;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.Task;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.TaskRequest;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.TaskResponse;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.retrofit.ApiClient;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.retrofit.ApiService;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.utility.SessionUtility;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TaskAdapter taskAdapter;
    ArrayList<Task> listTask = new ArrayList<>();
    SessionUtility sessionUtility;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        taskAdapter = new TaskAdapter(this, listTask);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(taskAdapter);
        sessionUtility = new SessionUtility(this);
        username = sessionUtility.loadName();
        password = sessionUtility.loadPassword();
        retrofit();
    }

    public void retrofit() {
        ApiService apiService = ApiClient.newInstance(getApplicationContext()).create(ApiService.class);

        TaskRequest taskRequest = new TaskRequest();
        Login param = new Login();
        param.setPassword(password);
        param.setUsername(username);
        taskRequest.setParamTask(param);
        taskRequest.setMethod("getProfileInfo");
        Call<TaskResponse> call = apiService.getTask(taskRequest);
        call.enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
//                isLoading = false;
                if (response.body() != null) {
                    if (response.body().getData().size() > 0) {
                        listTask.addAll(response.body().getData());
                        taskAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                recyclerView.setVisibility(View.GONE);
//                progressBarScroll.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.main_menu_item_menu:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Confirmation")
                        .setCancelable(false)
                        .setMessage("Are You Sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sessionUtility.saveLogin("", "");
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }).setNegativeButton("No", null).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
