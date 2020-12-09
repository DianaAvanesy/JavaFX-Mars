package Models;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Camera {
    private int id;
    private String name;

    @SerializedName("rover_id")
    private int roverId;

    @SerializedName("full_name")
    private String fullName;

    public Camera(int id, String name, int roverId, String fullName) {
        this.id = id;
        this.name = name;
        this.roverId = roverId;
        this.fullName = fullName;
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

    public int getRoverId() {
        return roverId;
    }

    public void setRoverId(int roverId) {
        this.roverId = roverId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    public String toString(){
        return name;
    }
    public static HashSet<Camera> getAllAvailibleRovers(List<PhotoUnit> units){
        HashSet<Camera> allRovers = new HashSet<Camera>();
        for (PhotoUnit photoUnit: units) {
            Camera camera = photoUnit.getCamera();
            allRovers.add(camera);
        }
        //List<String> list = new ArrayList<String>(allRovers);
        return  allRovers;

    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Camera && ((Camera) object).name.equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}