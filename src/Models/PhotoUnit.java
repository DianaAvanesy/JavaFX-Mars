package Models;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.Date;

public class PhotoUnit {

    private int id;
    private int sol;

    private Camera camera;

    @SerializedName("img_src")
    private String imgSource;

    @SerializedName("earth_date")
    private Date date;

    private Rover rover;

    public PhotoUnit(int id, int sol, Camera camera, String imgSource, Date date, Rover rover) {
        this.id = id;
        this.sol = sol;
        this.camera = camera;
        this.imgSource = imgSource;
        this.date = date;
        this.rover = rover;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Photo id should be more then 0. Not: " + id);
        }
    }

    public int getSol() {
        return sol;
    }

    public void setSol(int sol) {
        if(sol == 1000){
        this.sol = sol;}
        else
            throw new IllegalArgumentException("sol should be 1000. Not: " + id);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {


        this.imgSource = imgSource;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public String toString(){

        return "[ " +Integer.toString(id) + "]  " + getCamera().getFullName();
    }
}

