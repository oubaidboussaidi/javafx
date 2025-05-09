package stock;

public class Article {

    private final int ref;
    private String libelle, description, categorie;
    private float prixHT, TVA;
    private int quantite;
    private String unite;
    private int poids;
    private boolean fragile;
    private String consigne;
    private boolean promotion, enLigne;

    public float calculerTTc() {
        return prixHT * (1.f + TVA/100.f);
    }

    public String genererHTML() {
        String r = "";
        r = "<html>";
        r += "<head><title>" + description + "</title></head>";
        r += "<body>";
        r += "<h1>" + ref + "description : " + description + "</h1>";
        r+="<p>categorie : "+categorie+"</p>";
        r+="<p>prix h t : "+prixHT +" tva: "+TVA +" prix ttc: "+calculerTTc()+"</p>";
        r+="</body>";
        r += "</html>";
        return r;
    }

    public Article(int ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTVA() {
        return TVA;
    }

    public void setTVA(float TVA) {
        this.TVA = TVA;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public String getConsigne() {
        return consigne;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isEnLigne() {
        return enLigne;
    }

    public void setEnLigne(boolean enLigne) {
        this.enLigne = enLigne;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getRef() {
        return ref;
    }

    @Override
    public String toString() {
        return ref + "---" + libelle + "  " + description + " +++ " + categorie + "--" + quantite + " " + unite + "  " + poids + " kg " + (fragile ? "fragile" : "non fragile") + " " + consigne + " " + (promotion ? " en promotion" : "") + " " + (enLigne ? "enligne" : "");
    }

}