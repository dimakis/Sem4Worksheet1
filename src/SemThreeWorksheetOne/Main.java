package SemThreeWorksheetOne;

import controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    public static Stage pStage;
    public MenuItem openFinder;
    private Desktop desktop = Desktop.getDesktop();
    public HomeController homeCon;
    public Scene homeScene;

    @Override
    public void start(Stage pStage) throws Exception {

        FXMLLoader HomeCon = new FXMLLoader(getClass().getResource("../fxml/WorksheetOne.fxml"));
        Parent hs = HomeCon.load();
        homeCon = HomeCon.getController();

        homeScene = new Scene(hs);

//        Parent root = FXMLLoader.load(getClass().getResource("../fxml/WorksheetOne.fxml"));
        pStage.setTitle("Hello World");
        pStage.setScene(homeScene);
        pStage.show();
    }



        public static void main (String[]args){
            launch(args);
        }
    }
