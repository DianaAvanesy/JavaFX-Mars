
package Controllers;

import Models.PhotoUnit;
import Views.SceneAndStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class PhotoViewController implements Initializable {

    private PhotoUnit selectedPhotoUnit;
    @FXML
    private Button goBackButton;

    @FXML
    private ImageView imageView;

    @FXML
    private Label cameraLabel;

    @FXML
    private Label dateLabel;

    /**
     * This method gets the photo unit so it can be used to initilize the view
     * @param photoUnit - selected photoUnit from previos scene
     */
    public void initData(PhotoUnit photoUnit){
        selectedPhotoUnit = photoUnit;
        String url = selectedPhotoUnit.getImgSource();
       // url = url.replace("http://", "https://");
        imageView.setImage(new Image(url));
        cameraLabel.setText(selectedPhotoUnit.getCamera().getName());

        Date date = selectedPhotoUnit.getDate();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);

        dateLabel.setText(strDate);
    }

    @FXML
    void goBackToSearch(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/Views/searchNASAView.fxml"));
        SceneAndStage.setScene1(e, root);

    }


    /**
     * This method initialise a photoView
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
