package converter;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

/**
 * This class use to handle to calculate the different type of unit length.
 * @author Thanakrit Daorueang
 */

public class ConverterController {
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private Button convert;
    @FXML
    private Button clear;
    @FXML
    private ComboBox<Length> comboBox1;
    @FXML
    private ComboBox<Length> comboBox2;

    private static  Alert warningAlert = new Alert(Alert.AlertType.WARNING);


    /**
     * This method use to convert the value of each unit length.
     * @param event is the event is to use do an action.
     */
    @FXML
    public void handleConvert(ActionEvent event) {
        try {
            if (text1.getLength() != 0 && text2.getLength() == 0) {
                String text = text1.getText().trim();
                setTextHandle(text, text2);
            } else if (text2.getLength() != 0 && text1.getLength() == 0) {
                String text = text2.getText().trim();
                setTextHandle(text, text1);
            }else {
                String text = text1.getText().trim();
                setTextHandle(text, text2);
                warningAlert.setHeaderText("You need to clear before next calculate.");
                warningAlert.showAndWait();
            }

        } catch (Exception e) {
            e.getMessage();
        }


    }

    /**
     * This use to calculate the value of unit length.
     * @param text that user input in the text field.
     * @param textField is the test field use to calculate.
     */
    public void setTextHandle(String text, TextField textField) {
        if (Double.parseDouble(text) < 0) {
            warningAlert.setHeaderText("Input not valid");
            warningAlert.showAndWait();
        } else {
                Length unit1 = comboBox1.getValue();
                Length unit2 = comboBox2.getValue();
                textField.setText(String.format("%.4g",Double.parseDouble(text) * unit1.getValue() / unit2.getValue()));
                System.out.println("handleCovert converting " + text);
            }
        }


    /**
     * This use to clear the text field.
     */
    @FXML
    public void handleClear() {
        text1.setText(null);
        text2.setText(null);
    }

    /**
     * This use to add all the unit length to combo box.
     */
    @FXML
    public void initialize(){
        System.out.println("Running initialize");
        if (comboBox1!=null){
            comboBox1.getItems().addAll(Length.values());
            comboBox1.getSelectionModel().select(0);
        }
        if (comboBox2!=null){
            comboBox2.getItems().addAll(Length.values());
            comboBox2.getSelectionModel().select(1);
        }
    }

}
