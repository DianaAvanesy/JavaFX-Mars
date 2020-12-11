package Views;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SceneAndStage {

    public static void setScene1 (ActionEvent event, Parent root) {
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Views/styles.css");
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        Image icon = new Image("/img/mars.png");
        stage.getIcons().add(icon);
        stage.setTitle("  MARS  ");
        stage.show();




    }

}
