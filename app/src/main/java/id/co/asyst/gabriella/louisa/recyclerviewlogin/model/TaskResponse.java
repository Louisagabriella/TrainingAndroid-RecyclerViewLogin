package id.co.asyst.gabriella.louisa.recyclerviewlogin.model;

import java.util.ArrayList;

public class TaskResponse {
    String status;
    String message;
    ArrayList<Task> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Task> getData() {
        return data;
    }

    public void setData(ArrayList<Task> data) {
        this.data = data;
    }
}
