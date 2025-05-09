package stock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;

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
    private void avecConsigne(ActionEvent event){
        if(this.Consigne.isSelected()){
            this.Palette.setVisible(true);
            this.consBouteille.setVisible(true);
        }else{
            this.Palette.setVisible(false);
            this.consBouteille.setVisible(false);
        }
    }

    @FXML
    private void enLigne(ActionEvent event){
        if(Ligne.isSelected() && leArticle!=null){
            Editor.setVisible(true);
            Editor.setHtmlText(leArticle.genererHTML());
        }else{
            Editor.setVisible(false);
        }
    }

    @FXML
    private void enregistrer(ActionEvent event){
        String tref = Ref.getText();
        int r = Integer.parseInt(tref);

        this.leArticle = new Article(r);
        leArticle.setLibelle(this.Lib.getText());
        leArticle.setDescription(this.Desc.getText());
        leArticle.setCategorie(this.Cat.getValue());

        String tprix = this.Prix.getText();

        float pr = Float.parseFloat(tprix);
        leArticle.setPrixHT(pr);

        String ttva = this.Tva.getText();
        leArticle.setTVA(Float.parseFloat(ttva));

        if(this.Carton.isSelected()){
            leArticle.setUnite("carton");
        }else if (this.Boite.isSelected()){
            leArticle.setUnite("boite");
        }else if(this.Bouteille.isSelected()){
            leArticle.setUnite("bouteille");
        }

        leArticle.setPoids((int) Poids.getValue());

        if(Fragile.isSelected()){
            leArticle.setFragile(true);
        }else{
            leArticle.setFragile(false);
        }

        if(this.Consigne.isSelected()){
            if(this.Palette.isSelected()){
                leArticle.setConsigne("palette");
            }
        }else{
            if(this.consBouteille.isSelected()){
                leArticle.setConsigne("bouteille");
            }
        }

        if(this.Promo.isSelected()){
            leArticle.setPromotion(true);
        }

        if(this.Ligne.isSelected()){
            leArticle.setEnLigne(true);
        }
    }

    @FXML
    private void afficher(ActionEvent event){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("article");
        a.setContentText(leArticle.toString());
        a.show();
    }

    @FXML
    private void affichPrix(ActionEvent event){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("prix ttc de l'article");
        a.setContentText("prix ttc : "+leArticle.calculerTTc());
        a.show();
    }
}
