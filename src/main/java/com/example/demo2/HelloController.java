package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class HelloController {
    @FXML
    private Label resultLabel;
    @FXML
    private TextField wTextField;
    @FXML
    private TextField hTextField;
    @FXML
    private TextField nTextField;
    @FXML
    private Label nLabel;
    @FXML
    private Label errorLabel;
    @FXML
    private Label diagnosisLabel ;

    private NumberFormat heightNumberFormatter= NumberFormat.getNumberInstance();
    private NumberFormat weightFormatter = NumberFormat.getNumberInstance();

    @FXML
    protected void onCalculateBmi() {
        try{
                BigDecimal height = new BigDecimal(hTextField.getText());
                BigDecimal weight = new BigDecimal(wTextField.getText());

           // BigDecimal heightInMeters = height.divide(new BigDecimal("100"));
            BigDecimal bmi = weight.divide(height.pow(2), 2, RoundingMode.HALF_UP);


                resultLabel.setText(""+ bmi);

                String name = nTextField.getText();
                nLabel.setText(name +" Your BMI IS");

            if (bmi.compareTo(new BigDecimal("18.5")) < 0) {
                diagnosisLabel.setText("Underweight");
            } else if (bmi.compareTo(new BigDecimal("25")) <= 0) {
                diagnosisLabel.setText("Normal weight");
            } else if (bmi.compareTo(new BigDecimal("30")) <= 0) {
                diagnosisLabel.setText("Overweight");
            } else {
                diagnosisLabel.setText("Obese");
            }


        }
        catch (NumberFormatException e){
            errorLabel.setText("Kindly enter a numeric value");
            wTextField.setText("");
            hTextField.setText("");
            nTextField.setText("");

        }

    }
    @FXML
    protected void clearForm(){
        wTextField.setText("");
        hTextField.setText("");
        nTextField.setText("");
    }
}