package id.co.asyst.gabriella.louisa.recyclerviewlogin.retrofit;

import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.LoginRequest;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.LoginResponse;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.TaskRequest;
import id.co.asyst.gabriella.louisa.recyclerviewlogin.model.TaskResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("Login/getProfileInfo")
    Call<LoginResponse> getLogin(@Body LoginRequest loginRequest);

    @POST("Task/getAllTask")
    Call<TaskResponse> getTask(@Body TaskRequest taskRequest);
}
