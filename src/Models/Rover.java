package Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Rover {

    private int id;
    private String name;

    @SerializedName("landing_date")
    private Date landingDate;

    @SerializedName("launch_date")
    private Date launchDate;

    private String status;

    public Rover(int id, String name, Date landingDate, Date launchDate, String status) {
        this.id = id;
        this.name = name;
        this.landingDate = landingDate;
        this.launchDate = launchDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(Date landingDate) {
        this.landingDate = landingDate;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
