package Models;

import com.google.gson.annotations.SerializedName;

public class Camera {
    private int id;
    private String name;

    @SerializedName("rover_id")
    private int roverId;

    @SerializedName("full_name")
    private String fullName;

}
