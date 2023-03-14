package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonReset;

    @FXML
    private Button buttonTraslate;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtTesto;

    @FXML
    void doReset(ActionEvent event) {
    	this.txtTesto.clear();
    	this.txtParola.clear();   }

    @FXML
    void doTraslate(ActionEvent event) {
    	this.txtTesto.clear();
    	
    	String parole = txtParola.getText();
    	
    	if(parole.length()==0 || parole==null) {
    		txtTesto.setText("- Inserire una parola aliena per cercare la traduzione. "
    				+ "\n" + "- Inserire una parola aliena ed una umana, separate da una spazio,"
    				+ "\n" + "per inserirla nel dizionario."
    				+ "\n" + "Si possono inserire solo caratteri alfabetici.");
    		return;  }
    	
    	String[] splitted = parole.split(" ");
    	
    	if(splitted.length ==1) {
    		String alienWord = splitted[0];
    		
    		if(!alienWord.matches("^[a-zA-Z]*$")) {
    			txtTesto.setText("Sono validi solo i caratteri alfabetici!"); 
    			return;}
    			
    		String tradotta = this.model.traduzioneParola(alienWord);
    		if(tradotta != null) {
    			txtTesto.setText("La traduzione di " + alienWord +" è " + tradotta);
    			txtParola.clear();   }
    		else {
    		txtTesto.setText("La parola non ha ancora una traduzione"); }
}
    	
    	if(splitted.length==2) {
    		String alienWord = splitted[0];
    		String humanWord = splitted[1];
    		
    		if(!alienWord.matches("^[a-zA-Z]*$") || !humanWord.matches("^[a-zA-Z]*$")) {
    			txtTesto.setText("Sono validi solo i caratteri alfabetici!"); 
    			return;}
    		
    		this.model.inserireNelDizionario(humanWord, alienWord);
    		txtTesto.setText(alienWord + " è stata inserita con la sua traduzione " + humanWord);
    		txtParola.clear();
    	}

    	if(splitted.length>2) {
    		txtTesto.setText("Non rispettate le condizioni! Troppe parole inserite!");
    		return;
    	}
    }

    @FXML
    void initialize() {
        assert buttonReset != null : "fx:id=\"buttonReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonTraslate != null : "fx:id=\"buttonTraslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Dictionary model) {
		// TODO Auto-generated method stub
		this.model = model;
	}

	
	}
