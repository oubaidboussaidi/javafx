package stock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;
import org.w3c.dom.events.MouseEvent;

import javax.swing.*;

public class FXMLArticleController {

    @FXML private TextField Ref;
    @FXML private TextField Lib;
    @FXML private TextArea Desc;
    @FXML private ComboBox<String> Cat;
    @FXML private TextField Prix;
    @FXML private TextField Tva;
    @FXML private TextField Quant;
    @FXML private RadioButton Carton;
    @FXML private RadioButton Boite;
    @FXML private RadioButton Bouteille;
    @FXML private Slider Poids;
    @FXML private CheckBox Fragile;
    @FXML private CheckBox Consigne;
    @FXML private RadioButton Palette;
    @FXML private RadioButton consBouteille;
    @FXML private CheckBox Promo;
    @FXML private CheckBox Ligne;
    @FXML private HTMLEditor Editor;
    private Article leArticle;

    @FXML
    private void Enregistrer() {
        System.out.println("Bouton Enregistrer cliqué Ref : "+this.Ref.getText());
    }

    @FXML
    private void avecConsigne(ActionEvent event){
        if(this.Consigne.isSelected()){
            Palette.setVisible(true);
        }else{
            Palette.setVisible(false);
            consBouteille.setVisible(false);
        }
    }

    @FXML
    private void enLigne(MouseEvent event){
        if(Ligne.isSelected()){
            Editor.setVisible(true);
            Editor.setHtmlText(leArticle.genererHTML());
        }else{
            Editor.setVisible(false);
        }
    }
}
