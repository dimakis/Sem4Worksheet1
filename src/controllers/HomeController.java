package controllers;


import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static SemThreeWorksheetOne.Main.pStage;

public class HomeController implements Initializable {

    public MenuItem openFinder;
    public ImageView imageView, imageViewEdited, imageViewRed, imageViewGreen;
    public Button hueBtn, saturationBtn, brightnessBtn, contrastBtn, grayScaleBtn, cancelChanges;
    public Slider hueSlider, saturationSlider, sepiaSlider, brightnessSlider, contrastSlider, glowSlider;
    public Label saturationLabel, brightnessLabel, contrastLabel, glowLabel, sepiaLabel;
    public Pane imageMetaData;
    public ColorAdjust colorAdjust = new ColorAdjust();
    public double fileSize;
    public MenuItem quit;
//    public MetaData = new Metadata();


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
        setGrayScale();
        setCancelChanges();
        imageMeta();
    }

    public void setOpenFinder() {
        openFinder.setOnAction(e -> {

            final FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(pStage);
            fileSize = file.length();
            System.out.println("Filesize : " + fileSize);
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

    public void setSepia() {
        SepiaTone sepiaTone = new SepiaTone();
        sepiaLabel.setText("Sepia : ");
        sepiaSlider.setOnMouseReleased(e -> {
            sepiaTone.setLevel(sepiaSlider.getValue());
            imageViewEdited.setEffect(sepiaTone);
            sepiaLabel.setText("Sepia : " + sepiaSlider.getValue());
        });


    }

    public void setSaturation() {
        saturationLabel.setText("Saturation : ");
        saturationSlider.setOnMouseReleased(e -> {
            colorAdjust.setSaturation(saturationSlider.getValue());
            imageViewEdited.setEffect(colorAdjust);
            saturationLabel.setText("Saturation : " + saturationSlider.getValue());

        });
    }

    public void setBrightness() {
        brightnessLabel.setText("Brightness : ");
        brightnessSlider.setOnMouseReleased(e -> {
            colorAdjust.setBrightness(brightnessSlider.getValue());
            imageViewEdited.setEffect(colorAdjust);
            brightnessLabel.setText("Brightness : " + brightnessSlider.getValue());
        });
    }

    public void setContrast() {
        contrastLabel.setText("Contrast : ");
        contrastSlider.setOnMouseReleased(e -> {
            colorAdjust.setContrast(contrastSlider.getValue());
            imageViewEdited.setEffect(colorAdjust);
            contrastLabel.setText("Contrast : " + contrastSlider.getValue());
        });
    }

    public void setGrayScale() {
        grayScaleBtn.setOnAction(e -> {
                    Image im = imageViewEdited.getImage();
                    PixelReader pixelReader = im.getPixelReader();
                    WritableImage writableImage = new WritableImage(
                            (int) im.getWidth(), (int) im.getHeight());
                    PixelWriter pixelWriter = writableImage.getPixelWriter();

                    for (int y = 0; y < im.getHeight(); y++) {
                        for (int x = 0; x < im.getWidth(); x++) {
                            Color color = pixelReader.getColor(x, y);
                            double r = color.getRed();
                            double g = color.getGreen();
                            double b = color.getBlue();
                            int red = (int) ((r + g + b) / 3 * 255);
                            int green = (int) ((r + g + b) / 3 * 255);
                            int blue = (int) ((r + g + b) / 3 * 255);
                            color = Color.rgb(red, green, blue);
                            pixelWriter.setColor(x, y, color);
                        }
                    }
                    imageViewEdited.setImage(writableImage);
                }
        );
    }

    public void setCancelChanges() {
        SepiaTone st = new SepiaTone();
        cancelChanges.setOnAction(e -> {
            sepiaSlider.setValue(0);
            st.setLevel(0);
            saturationSlider.setValue(0);
            contrastSlider.setValue(0);
            brightnessSlider.setValue(0);
            colorAdjust.setContrast(0);
            colorAdjust.setBrightness(0);
            colorAdjust.setSaturation(0);
            Image freshImage = imageView.getImage();
            imageViewEdited.setImage(null);
            imageViewEdited.setImage(freshImage);
            imageViewEdited.setEffect(colorAdjust);
            sepiaLabel.setText("Sepia : ");
            saturationLabel.setText("Saturation : ");
            brightnessLabel.setText("Brightness : ");
            contrastLabel.setText("Contrast : ");
        });
    }

    public void rgbImages() {
        Image im = imageView.getImage();
        PixelReader pixelReader = im.getPixelReader();
        WritableImage writableImageRed = new WritableImage((int) im.getWidth(), (int) im.getHeight());
        WritableImage writableImageGreen = new WritableImage((int) im.getWidth(), (int) im.getHeight());
        WritableImage writableImageBlue = new WritableImage((int) im.getWidth(), (int) im.getHeight());
        PixelWriter pixelWriterR = writableImageRed.getPixelWriter();
        PixelWriter pixelWriterG = writableImageGreen.getPixelWriter();
        PixelWriter pixelWriterB = writableImageBlue.getPixelWriter();




        for (int y = 0; y < im.getHeight(); y++) {
            for (int x = 0; x < im.getWidth(); x++) {
                Color color = pixelReader.getColor(x, y);


            }
        }
    }

    public void imageMeta() {
        Image im = imageView.getImage();
        imageMetaData.setAccessibleText("File Name : " + im.getUrl());
        System.out.println(im.getUrl());

//        try {
//            ImageInputStream iis = ImageIO.createImageInputStream(imageView.getImage());
//            ImageReader reader = ImageIO.getImageReader((ImageWriter) iis);
//            IIOMetadata metadata = reader.getImageMetadata(0);
//            imageMetaData.setAccessibleText("metadata");
//            imageMetaData.setDisable(true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    public void quit()  {
        quit.setOnAction(e -> Platform.exit());
    }

}
