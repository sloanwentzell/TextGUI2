package sample;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;

public class Controller {
    public TextField textField;
    public ImageView imageView;

    private Model model;

    public void initialize() {
        System.out.println("Controller initialize");

        String imgP1 = "s";
        String imgP2 = "p";
        String imgP3 = "S";

        Image openedImage = new Image("sample/" + imgP1 + imgP2 + imgP3 +".png");
        imageView.setImage(openedImage);

        try {
            File savedText = new File(getClass().getResource("SavedText.txt").toURI());
            if (savedText.exists()) {
                BufferedReader input = new BufferedReader(new FileReader(savedText));
                model = new Model(input);
                input.close();
            } else {
                model = new Model();
            }
        } catch (Exception e) {
            System.out.println("Controller initialize EXCEPTION");
            model = new Model();
        }

        textField.setText(model.getTopLabelText());
    }

    public void save() {
        System.out.println("Controller save");

        model.setTopLabelText(textField.getText());

        try {
            File savedText = new File(getClass().getResource("SavedText.txt").toURI());
            BufferedWriter writer = new BufferedWriter(new FileWriter(savedText));
            if (writer != null) {
                model.save(writer);
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Controller save EXCEPTION");
        }
    }

    public void keyTyped(){
        System.out.println(textField.getText());
        String text = textField.getText();
        char[] chars = new char[3];
        text.getChars(0,3, chars, 0);
        System.out.println("sample/" + chars[0] + chars[1] + chars[2] +".png");
        Image openedImage = new Image("sample/" + chars[0] + chars[1] + chars[2] +".png");
        imageView.setImage(openedImage);



    }
}
