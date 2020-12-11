package Models;

import com.google.gson.annotations.SerializedName;
import javafx.scene.image.Image;

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
        setId(id);
        setSol(sol);
        setCamera(camera);
        setImgSource(imgSource);
        setDate(date);
        setRover(rover);
    }


    public int getId() {
        return id;
    }

    /**
     * This method sets id and makes sure that the id is greater then 0
     * @param id
     */
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

    /**
     * This methid sets sol and makes sure that sol is equals to 1000
     * @param sol
     */
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

    /**
     * Method returns url with https at the begining of the url
     * Just in case if setter failed to set the link correctly
     * @return
     */
    public String getImgSource() {
        return imgSource.replace("http://", "https://");

    }

    /**
     * Method sets the url and making sure the url have https at the beggining
     * @param imgSourceB
     */
    public void setImgSource(String imgSourceB) {
        if(imgSourceB.contains("http://")){
            String imgSourceFixed = imgSourceB.replace("http://", "https://");
            this.imgSource = imgSourceFixed;
        }
        else if (imgSourceB.contains("https://")){
            this.imgSource = imgSourceB;
        }
        else
            throw new IllegalArgumentException("Please make sure the picture URL starts from https:// or http://");
    }

    public Date getDate() {
        return date;
    }

    /**
     * This setter makes sure that the date of the picture is not before the landing date,
     * otherwise throw an Exception
     * @param date
     */
    public void setDate(Date date) {
        if(date.after(new Date(2012,8,6))){
            this.date = date;
        }
        else
            throw new IllegalArgumentException("Please make sure the date of the photo after 2012.08.06");

    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    /**
     * Overriding toString method to display objects in the table with a human readble names
     * @return String representation of the object
     */
    @Override
    public String toString(){
        return "[ id: " +Integer.toString(id) + "]  " + getCamera().getFullName();
    }
}

