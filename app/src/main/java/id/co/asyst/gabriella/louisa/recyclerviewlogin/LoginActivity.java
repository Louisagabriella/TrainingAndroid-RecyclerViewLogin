package id.co.asyst.gabriella.louisa.recyclerviewlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.Login;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.LoginRequest;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.LoginResponse;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.retrofit.ApiClient;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.retrofit.ApiService;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.utility.SessionUtility;
import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPassword;
    Button bLogin;
    SessionUtility sessionUtility;

    //    boolean isLoading = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etName = findViewById(R.id.editTextName);
        etPassword = findViewById(R.id.editTextPassword);
        bLogin = findViewById(R.id.buttonLogin);
        sessionUtility = new SessionUtility(this);
        bLogin.setOnClickListener(this);
        String username = sessionUtility.loadName();
        etName.setText(username);
        String password = sessionUtility.loadPassword();
        etPassword.setText(password);
        if (etPassword.getText().toString() != null && etName.getText().toString() != null) {
            requestLogin();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                if (etPassword.getText().toString() != null && etName.getText().toString() != null) {
                    requestLogin();
                } else {
                    Toast.makeText(getApplicationContext(), "Masukkan Password dan Username", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void requestLogin() {
        ApiService apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiService.class);

        LoginRequest loginRequest = new LoginRequest();

        Login param = new Login();
        param.setPassword(etPassword.getText().toString());
        param.setUsername(etName.getText().toString());

        loginRequest.setParam(param);
        loginRequest.setMethod("getProfileInfo");

        Call<LoginResponse> call = apiServices.getLogin(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                //ifSuccess
//                if (response.body().equals("success")){
                sessionUtility.saveLogin(etName.getText().toString(), etPassword.getText().toString());
                Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
//                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Password Or Username Error", Toast.LENGTH_SHORT).show();
                //ifFailed

            }
        });
    }

}
