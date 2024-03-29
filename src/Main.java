import Utilities.APIUtility;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/searchNASAView.fxml"));
        //primaryStage.setScene(new Scene(root));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Views/styles.css");
        primaryStage.setScene(scene);
        Image icon = new Image("/img/mars.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("  MARS  ");
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
        try
        {
            APIUtility.callNasaAPI("&page=1");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
