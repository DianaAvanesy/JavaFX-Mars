package Controllers;

import Models.Camera;
import Models.NASAJsonResponse;
import Models.PhotoUnit;
import Models.Rover;
import Utilities.APIUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class SearchNASAViewController implements Initializable {

    @FXML
    private ListView<PhotoUnit> listView;

    @FXML
    private Button searchButton;


    @FXML
    private ComboBox<Camera> comboBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private void getPictureUnits(){

        //String searchURL = searchTextField.getText();
        String search = "" ;
        String camera = null;
        LocalDate date = null;

        if(comboBox.getValue() != null){
            camera = comboBox.getValue().toString();}
        if (datePicker.getValue() != null){
            date = datePicker.getValue();}

        if(date != null){
            search = "&earth_date=" + date.toString();
        }
        if(camera != null){
            search = search + "&camera=" + camera;
        }



        listView.getItems().clear();
        try {
            NASAJsonResponse response = APIUtility.callNasaAPI(search);
            List<PhotoUnit> photoUnits = Arrays.asList(response.getResults());
            listView.getItems().addAll(photoUnits);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setPromptText("Select Camera");

        NASAJsonResponse response = null;
        List<PhotoUnit> photoUnits = null;
        try {
            response = APIUtility.callNasaAPI("");
            photoUnits = Arrays.asList(response.getResults());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e ){
            e.printStackTrace();
        }

        HashSet<Camera> options =  Camera.getAllAvailibleRovers(photoUnits);
       // options.so
        comboBox.getItems().addAll(options);


    }
}
