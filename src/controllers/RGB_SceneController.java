package controllers;

import SemThreeWorksheetOne.Main;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class RGB_SceneController implements Initializable {

    public ImageView imageViewR;
    public ImageView imageViewG;
    public ImageView imageViewB;
    public MenuItem quit;
    HomeController homCon = Main.homeCon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setQuit();
    }

    public void rgbImages() {
        Image im = Main.homeCon.imageView.getImage();
        PixelReader pixelReader = im.getPixelReader();
        int width = (int) im.getWidth();
        int height = (int) im.getHeight();

        WritableImage writableImageRed = new WritableImage(width,height);
        WritableImage writableImageGreen = new WritableImage(width,height);
        WritableImage writableImageBlue = new WritableImage(width,height);
        PixelWriter pixelWriterR = writableImageRed.getPixelWriter();
        PixelWriter pixelWriterG = writableImageGreen.getPixelWriter();
        PixelWriter pixelWriterB = writableImageBlue.getPixelWriter();

        for (int y = 0; y < im.getHeight(); y++) {
            for (int x = 0; x < im.getWidth(); x++) {
                Color color = pixelReader.getColor(x, y);
                pixelWriterR.setColor(x, y, new Color(color.getRed(), 0, 0, 1));
                pixelWriterG.setColor(x,y, new Color(0,color.getGreen(),0.0,1));
                pixelWriterB.setColor(x,y, new Color(0,0, color.getBlue(),1));
            }
        }
        imageViewR.setImage(writableImageRed);
        imageViewB.setImage(writableImageBlue);
        imageViewG.setImage(writableImageGreen);
    }


    public void setQuit()   {
        quit.setOnAction(e -> Platform.exit());
    }
}

