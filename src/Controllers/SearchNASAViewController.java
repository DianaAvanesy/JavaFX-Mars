package Controllers;

import Models.Camera;
import Models.NASAJsonResponse;
import Models.PhotoUnit;
import Utilities.APIUtility;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
    private  Label instructionsLabel;

    /**
     * This method gets called when button searchButton pressed
     * The method creates a string that will be used to call API based on the parameter(s) provided by user
     */
    @FXML
    private void getPictureUnits(){
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


    /**
     * This method initialize the SearchNASAView
     * part of initialization this method
     *     gets all availible Cameras from API and puts it in combobox for user to select from
     *     sets a listener on the tableView
     * @param url
     * @param resourceBundle
     */
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
        HashSet<Camera> options =  Camera.getAllAvailibleCameras(photoUnits);
        comboBox.getItems().addAll(options);

        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, value, selected) -> {
                    try {
                        changeToDetailsView(selected);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        );

    }

    /**
     * This method gets called when Listener on listView from initialize method gets triggered
     * The method changes the scene to photoView and by directly accessing the PhotoViewController passes information
     * about selected photoUnit
     * @param photoUnit - selected unit
     * @throws IOException
     */
    @FXML
    void changeToDetailsView(PhotoUnit photoUnit) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/photoView.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        scene.getStylesheets().add("Views/styles.css");
        Stage primaryStage = (Stage) listView.getScene().getWindow();
        primaryStage.setScene(scene);

        //access the controller
        PhotoViewController controller = loader.getController();
        controller.initData(photoUnit);

        Image icon = new Image("/img/mars.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("  MARS  ");
        primaryStage.show();


    }



}
