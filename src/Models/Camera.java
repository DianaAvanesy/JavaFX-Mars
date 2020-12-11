package Models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Camera {


    private int id;
    private String name;

    @SerializedName("rover_id")
    private int roverId;

    @SerializedName("full_name")
    private String fullName;

    public Camera(int id, String name, int roverId, String fullName) {
        setId(id);
        setName(name);
        setRoverId(roverId);
        setFullName(fullName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0 && id < 1000) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Camera id should be in a range of 0-1000. Not: " + id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        List<String> nameOptions = Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM", "PANCAM", "MINITES");

        if (nameOptions.contains(name))
            this.name = name;
        else
            throw new IllegalArgumentException("Camera name must be one of options from the list below: "+
                    nameOptions);
    }

    public int getRoverId() {
        return roverId;
    }

    public void setRoverId(int roverId) {
        if (roverId == 5) {
            this.roverId = roverId;
        } else {
            throw new IllegalArgumentException("Curiosity Rover id for the cameras should be 5. Not: " + roverId);
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {

        HashMap<String, String> options = new HashMap<String, String>();

        options.put("FHAZ","Front Hazard Avoidance Camera");
        options.put("RHAZ","Rear Hazard Avoidance Camera");
        options.put("MAST","Mast Camera");
        options.put("CHEMCAM","Chemistry and Camera Complex");
        options.put("MAHLI","Mars Hand Lens Imager");
        options.put("MARDI","Mars Descent Imager");
        options.put("NAVCAM","Navigation Camera");
        options.put("PANCAM","Panoramic Camera");
        options.put("MINITES","Miniature Thermal Emission Spectrometer (Mini-TES)");

        String corespondingFullCameraName = options.get(name);

        if (corespondingFullCameraName.equals(fullName))
            this.fullName = fullName;
        else
            throw new IllegalArgumentException("Based on this camera name: " + name + " the full name should be: " +corespondingFullCameraName + " NOT: "+fullName);
    }

    public String toString(){
        return name;
    }

    /**
     * This methods returns all availible cameras names(with no sublicates) based on the PhotoUnits
     * @param photoUnits - dataset of all units
     * @returns HashSet<Camera>
     */
    public static HashSet<Camera> getAllAvailibleCameras(List<PhotoUnit> photoUnits){
        HashSet<Camera> allRovers = new HashSet<Camera>();
        for (PhotoUnit photoUnit: photoUnits) {
            Camera camera = photoUnit.getCamera();
            allRovers.add(camera);
        }
        return  allRovers;

    }

    /**
     * This method overrides equals by making objects equals if their names are equals
     * Used in the context of identifying equal cameras for getAllAvailibleCameras hashset
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        return object instanceof Camera && ((Camera) object).name.equals(name);
    }


    /**
     * Rule by witch the hash code gets generated base on name value.
     * @return
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

}