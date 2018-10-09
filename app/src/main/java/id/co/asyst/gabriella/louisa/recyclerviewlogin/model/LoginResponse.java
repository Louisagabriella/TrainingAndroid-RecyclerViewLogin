package id.co.asyst.gabriella.louisa.recyclerviewlogin.model;

public class LoginResponse {
    String status;
    String message;
    Response data;

    public Response getData() {
        return data;
    }

    public void setData(Response data) {
        this.data = data;
    }

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
}
