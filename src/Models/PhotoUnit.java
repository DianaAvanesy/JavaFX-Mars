package Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PhotoUnit {

    private int id;
    private int sol;
    // camera

    @SerializedName("img_scr")
    private String imgSource;

    @SerializedName("earth_date")
    private Date date;

    //rover - object


}

