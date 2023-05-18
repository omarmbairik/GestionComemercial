package ma.project.models;

public class ProduitDto {
    private ProduitIDDto produitID;
    private String name;
    private String couleur;
    private double prix;
    private FournisseurDto fournisseur;

    public ProduitDto(ProduitIDDto produitID) {
        this.produitID = produitID;
    }

    public ProduitDto() {
    }

    public ProduitIDDto getProduitID() {
        return produitID;
    }

    public void setProduitID(ProduitIDDto produitID) {
        this.produitID = produitID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public FournisseurDto getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "ProduitDto{" +
                "produitID=" + produitID +
                ", name='" + name + '\'' +
                ", couleur='" + couleur + '\'' +
                ", prix=" + prix +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
