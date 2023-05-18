package ma.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "Produit")
public class ProduitEntity {
    @EmbeddedId
    private ProduitIDEntity produitID;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 20)
    private String couleur;
    @Column(nullable = false)
    private double prix;
    @ManyToOne
    @JoinColumn(name = "fournisseur", nullable = false)
    private FournisseurEntity fournisseur;

    public ProduitIDEntity getProduitID() {
        return produitID;
    }

    public void setProduitID(ProduitIDEntity produitID) {
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

    public FournisseurEntity getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurEntity fournisseur) {
        this.fournisseur = fournisseur;
    }
}
