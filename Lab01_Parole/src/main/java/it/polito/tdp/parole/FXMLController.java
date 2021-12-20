package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtPerformance"
    private TextField txtPerformance; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCancella(ActionEvent event) {
        String temp = txtResult.getSelectedText();
        double start = System.nanoTime();
        elenco.removeParola(temp);
        double end = System.nanoTime();


        //Stampare elenco parole
        String result = "";
        for(String s: elenco.getElenco()){
            result += s + "\n";
        }

        txtResult.setText(result);
        txtPerformance.setText("Tempo di esecuzione: "+ (end-start)/1e9 + " secondi.");


    }

    @FXML
    void doInsert(ActionEvent event) {
        String temp = txtParola.getText();
        double start = System.nanoTime();
        elenco.addParola(temp);
        double end = System.nanoTime();
        txtResult.clear();
        txtParola.clear();

        //Stampare elenco parole
        String result = "";
        for(String s: elenco.getElenco()){
            result += s + "\n";
        }

        txtResult.setText(result);
        txtPerformance.setText("Tempo di esecuzione: "+ (end-start)/1e9 + " secondi.");


    }

    @FXML
    void doReset(ActionEvent event) {
        double start = System.nanoTime();
        elenco.reset();
        double end = System.nanoTime();
        txtResult.clear();
        txtPerformance.setText("Tempo di esecuzione: "+ (end-start)/1e9 + " secondi.");


    }


    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
