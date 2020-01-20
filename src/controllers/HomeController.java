package controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static SemThreeWorksheetOne.Main.pStage;

public class HomeController implements Initializable {

    public MenuItem openFinder;
    public ImageView imageView, imageViewEdited;
    public Button hueBtn, saturationBtn, brightnessBtn, contrastBtn, grayScaleBtn;
    public Slider hueSlider, saturationSlider, sepiaSlider, brightnessSlider, contrastSlider, glowSlider;
    public Label saturationLabel, brightnessLabel, contrastLabel;
    public Label sepiaLabel;
    public Label glowLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("/home/dimdakis/IdeaProjects/CA_02.1/Assignment_2/src/Images/cantFindImageFinal.png");
        Image im = new Image(file.toURI().toString());
        imageView.setImage(im);
        imageViewEdited.setImage(im);
        setOpenFinder();
        setSaturation();
        setBrightness();
        setContrast();
        setSepia();
    }

    public void setOpenFinder() {
        openFinder.setOnAction(e -> {

            final FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(pStage);
            Image im = new Image(file.toURI().toString());
            imageView.setImage(im);
            imageView.setPreserveRatio(true);
            imageViewEdited.setImage(im);
            imageViewEdited.setPreserveRatio(true);

//            try {
//                BufferedImage bi = ImageIO.read(file);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
        });
    }

    public void setGlow() {

    }

    public void setSepia()  {
        SepiaTone sepiaTone = new SepiaTone();
        sepiaLabel.setText("Sepia : ");
        sepiaSlider.setOnMouseReleased(e -> {
            sepiaTone.setLevel(sepiaSlider.getValue());
            imageViewEdited.setEffect(sepiaTone);
            sepiaLabel.setText("Sepia : " + sepiaSlider.getValue());
        });


    }

    public void setSaturation() {
        ColorAdjust colorAdjust = new ColorAdjust();
        saturationLabel.setText("Saturation : ");
//        saturationSlider.setMax(1);
        saturationSlider.setOnMouseReleased(e -> {
            colorAdjust.setSaturation(saturationSlider.getValue());
            imageViewEdited.setEffect(colorAdjust);
            saturationLabel.setText("Saturation : " + saturationSlider.getValue());

        });
    }

    public void setBrightness() {
        ColorAdjust colorAdjust = new ColorAdjust();
        brightnessLabel.setText("Brightness : ");
        brightnessSlider.setOnMouseReleased(e -> {
            colorAdjust.setBrightness(brightnessSlider.getValue());
            imageViewEdited.setEffect(colorAdjust);
            brightnessLabel.setText("Brightness : " + brightnessSlider.getValue());
        });
    }

    public void setContrast()     {
        ColorAdjust colorAdjust = new ColorAdjust();
        contrastLabel.setText("Contrast : ");
        contrastSlider.setOnMouseReleased(e -> {
            colorAdjust.setContrast(contrastSlider.getValue());
            imageViewEdited.setEffect(colorAdjust);
            contrastLabel.setText("Contrast : " + contrastSlider.getValue());
        });
    }

}
