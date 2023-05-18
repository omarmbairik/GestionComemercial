package ma.project.models;

public class AdresseDto {
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

    @Override
    public String toString() {
        return "AdresseDto{" +
                "ville='" + ville + '\'' +
                ", cp='" + cp + '\'' +
                ", rue='" + rue + '\'' +
                '}';
    }
}
