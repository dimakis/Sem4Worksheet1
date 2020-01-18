package controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static SemThreeWorksheetOne.Main.pStage;

public class HomeController implements Initializable {
    public MenuItem openFinder;
    public ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setOpenFinder();
    }

    public void setOpenFinder() {
        openFinder.setOnAction(e -> {

            final FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(pStage);
            Image im = new Image(file.toURI().toString());
            imageView.setImage(im);

        });
    }

}
