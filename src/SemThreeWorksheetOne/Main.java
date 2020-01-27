package SemThreeWorksheetOne;

import controllers.HomeController;
import controllers.RGB_SceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage pStage, sStage;
    public static HomeController homeCon;
    public static RGB_SceneController rgbCon;
    public Scene homeScene;
    public static Scene rgb_scene;

    @Override
    public void start(Stage pStage) throws Exception {

        FXMLLoader HomeCon = new FXMLLoader(getClass().getResource("../fxml/WorksheetOne.fxml"));
        Parent hs = HomeCon.load();
        homeCon = HomeCon.getController();
        homeScene = new Scene(hs);

        pStage.setTitle("Hello World");
        pStage.setScene(homeScene);
        pStage.show();

        sStage = new Stage();
        FXMLLoader RGB_Con = new FXMLLoader(getClass().getResource("../fxml/rgbScene.fxml"));
        Parent rgbPar = RGB_Con.load();
        rgbCon = RGB_Con.getController();
        rgb_scene = new Scene(rgbPar);
    }


        public static void main (String[]args){
            launch(args);
        }
    }
