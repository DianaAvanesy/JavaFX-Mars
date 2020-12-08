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

}
