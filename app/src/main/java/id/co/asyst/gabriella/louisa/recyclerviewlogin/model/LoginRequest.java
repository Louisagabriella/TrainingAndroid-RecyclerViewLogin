package id.co.asyst.gabriella.louisa.recyclerviewlogin.model;

public class LoginRequest {
    String method;
    Login param;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParam(Login param) {
        this.param = param;
    }
}
