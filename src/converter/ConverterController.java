package converter;

import com.sun.javafx.scene.layout.region.Margins;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.awt.*;

/**
 * This class use to handle to calculate the different type of unit length.
 *
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
    private ComboBox<Unit> comboBox1;
    @FXML
    private ComboBox<Unit> comboBox2;
    @FXML
    private Menu unit;
    @FXML
    private MenuItem length;
    @FXML
    private MenuItem weight;
    @FXML
    private MenuItem temperature;
    @FXML
    private MenuItem exit;

    private static Alert warningAlert = new Alert(Alert.AlertType.WARNING);


    /**
     * This method use to convert the value of each unit length.
     *
     * @param event is the event is to use do an action.
     */
    @FXML
    public void handleConvert(ActionEvent event) {
        try {
            text1.setStyle("-fx-border-color: none");
            text2.setStyle("-fx-border-color: none");
            Unit unit1 = comboBox1.getValue();
            Unit unit2 = comboBox2.getValue();
            if (event.getSource()==text1) {

                String text = text1.getText().trim();
                double value = unit1.convert(Double.parseDouble(text),unit2);
                text2.setText(String.format("%.6g",value));
            } else {
                String text = text2.getText().trim();
                double value = unit2.convert(Double.parseDouble(text),unit1);
                text1.setText(String.format("%.6g",value));
            }
        } catch (Exception e) {
            e.getMessage();
            text1.setStyle("-fx-border-color: red");
            text2.setStyle("-fx-border-color: red");
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
     * This use to load item to combobox.
     * @param unitType the type of unit.
     */
    @FXML
   public void loadUnitType(UnitType unitType){
        Unit<?>[] units = UnitFactory.getInstance().getUnits(unitType);
        if (comboBox1!=null){
            comboBox1.getItems().clear();
            comboBox1.getItems().addAll(units);
            comboBox1.getSelectionModel().select(0);
        }
        if (comboBox2!=null){
            comboBox2.getItems().clear();
            comboBox2.getItems().addAll(units);
            comboBox2.getSelectionModel().select(1);
        }
   }

    /**
     * Event handle for selecting unit type.
     * @param event
     */
    public void handleUnitSelected(ActionEvent event) {
        MenuItem mitem = (MenuItem) event.getSource();
        String unitname = mitem.getText();
        UnitType unittype = UnitType.valueOf(unitname);
        loadUnitType(unittype);
    }

    /**
     * This use to exit the program.
     */
    @FXML
    public void exit() {
        System.exit(0);
    }

}
