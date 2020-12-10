
package Controllers;

import Models.PhotoUnit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PhotoViewController implements Initializable {

    private PhotoUnit selectedPhotoUnit;
    @FXML
    private Button goBackButton;

    @FXML
    private ImageView imageView;

    /**
     * This method gets the photo unit so it can be used to initilize the view
     * @param photoUnit - selected photoUnit from previos scene
     */
    public void initData(PhotoUnit photoUnit){
        selectedPhotoUnit = photoUnit;
        Image image = null;
        String picURl = photoUnit.getImgSource();
        image = new Image(picURl);

        imageView.setImage(image);
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
