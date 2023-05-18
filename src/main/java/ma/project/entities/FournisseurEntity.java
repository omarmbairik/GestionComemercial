package ma.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "Fournisseur")
public class FournisseurEntity {
    @Id
    private String cin;
    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cp", column = @Column(name = "codePostal", length = 5,nullable = false)),
            @AttributeOverride(name = "rue", column = @Column(length = 60, nullable = false)),
            @AttributeOverride(name = "ville", column = @Column(nullable = false))
    })
    private AdresseEntity adresse;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }
}
