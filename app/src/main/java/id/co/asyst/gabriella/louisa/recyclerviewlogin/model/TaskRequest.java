package id.co.asyst.gabriella.louisa.recyclerviewlogin.model;

import com.google.gson.annotations.SerializedName;

public class TaskRequest {
    String method;
    @SerializedName("param")
    Login paramTask;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Login getParamTask() {
        return paramTask;
    }

    public void setParamTask(Login paramTask) {
        this.paramTask = paramTask;
    }
}
