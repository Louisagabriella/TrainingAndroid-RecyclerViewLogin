package id.co.asyst.gabriella.louisa.recyclerviewlogin.model;

import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("customer_id")
    String id;
    @SerializedName("customer_name")
    String name;
    @SerializedName("customer_address")
    String address;
    @SerializedName("task_id")
    String serialNumber;
    @SerializedName("startDate")
    String startDate;
    @SerializedName("finishDate")
    String finishDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }
}
