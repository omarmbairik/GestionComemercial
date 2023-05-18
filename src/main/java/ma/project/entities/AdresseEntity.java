package ma.project.entities;

import javax.persistence.Embeddable;

@Embeddable
public class AdresseEntity {
    private String ville;
    private String cp;
    private String rue;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }
}
