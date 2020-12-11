package Models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.*;

public class Rover {

    private int id;
    private String name;

    @SerializedName("landing_date")
    private Date landingDate;

    private Date launchDate;

    private String status;

    public Rover(int id, String name, Date landingDate, Date launchDate, String status) {
        setId(id);
        setName(name);
        setLandingDate(landingDate);
        setLaunchDate();
        setStatus(status);
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
            throw new IllegalArgumentException("Rover id should be more then 0. Not: " + id);
        }
    }

    public String getName() {
        return name;
    }

    /**
     * This method sets Rover name only if its Curiosity( in context of this project it should always be Curiosity)
     * @param name
     */
    public void setName(String name) {
        if(name.equals("Curiosity")){
            this.name = name;}
        else
            throw new IllegalArgumentException("Name of the Rover should be Curiosity. Not: " + name);
    }

    public Date getLandingDate() {
        return landingDate;
    }

    /**
     * This method makes sure that Launding date is after LaunchDate
     * @param landingDate
     */
    public void setLandingDate(Date landingDate) {
        if(landingDate.after(new Date(2012,8,6))){
            this.landingDate = landingDate;
        }
        else
            throw new IllegalArgumentException("Please make sure the landingDate for the Rover is after 2012.08.06");
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    /**
     * Sets launchDate to the launch Date of the Rover(in this case always the same date)
     */
    public void setLaunchDate() {
        this.launchDate = new Date(2012,8,6);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Overrides toString method to return only the name
     * @return
     */
    @Override
    public String toString(){
         return name;
    }

}
