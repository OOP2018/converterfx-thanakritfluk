package converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class use to run ui.
 * @author Thanakrit Daorueang
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = (Parent)FXMLLoader.load(getClass().getResource("ConverterUI.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.sizeToScene( );
            stage.show();
        } catch(Exception e) {
            System.out.println("Exception creating scene: "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
