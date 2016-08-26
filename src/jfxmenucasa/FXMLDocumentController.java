/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxmenucasa;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author a.marchetto
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label lIPNumber;
    @FXML
    private Label lActTemp;
    @FXML
    private TextField tSetTemp;

    @FXML
    private Label lActUmid;
    @FXML
    private Label lSetTemp;

    private Termometro trm;
    private Contatore c;

    public FXMLDocumentController() {
        c = new Contatore(20, 0.5);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void handleRsalottoEvent(ActionEvent event) {
        System.out.println("Selezionato il salotto");
        label.setText("HPippo, Pippo, Pippo!");
        CompilaCampi("192.168.0.50");
    }

    @FXML
    private void handleRCucinaEvent(ActionEvent event) {
        System.out.println("Selezionato la cucina");
        CompilaCampi("192.168.0.51");
    }

    @FXML
    private void handlePiuCount(ActionEvent event) {

        c.incrementa();

        aggiornaTemp();
    }

    @FXML
    private void handleMenoCount(ActionEvent event) {
        c.decrementa();
        aggiornaTemp();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//         TODO
    }

    private void CompilaCampi(String ipAddr) {

        trm = new Termometro(ipAddr);

        lIPNumber.setText(ipAddr);
        lActTemp.setText(trm.getActTemp());
        lActUmid.setText(trm.getActUmid());
        lSetTemp.setText(trm.getSetTemp());

    }

    private void aggiornaTemp() {
        tSetTemp.setText(Double.toString(c.getCount()));
        //System.out.println(c.getCount());
    }

}
