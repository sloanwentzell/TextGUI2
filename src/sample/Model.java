package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Model {
    private String topLabelText;

    Model() {
        System.out.println("Model()");
        topLabelText = "";
    }

    Model(BufferedReader input) {
        System.out.println("Model(BufferedReader input)");
        try {
            topLabelText = input.readLine();
        } catch (Exception e) {
            System.out.println("Model reading failed!!!");
        }
    }

    void save(BufferedWriter output) {
        try {
            if (topLabelText != null) {
                output.write(topLabelText);
            } else {
                output.write("");
            }
        } catch (Exception e) {

            System.out.println("Model writing failed!!!");
            e.printStackTrace();
        }

    }

    String getTopLabelText() {
        return topLabelText;
    }
    void setTopLabelText(String updatedText) {
        topLabelText = updatedText;
    }
}
