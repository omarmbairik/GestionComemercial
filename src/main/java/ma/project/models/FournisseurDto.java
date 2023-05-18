package ma.project.models;

public class FournisseurDto {
    private String cin;
    private String name;
    private AdresseDto adresse;

    public FournisseurDto() {
    }

    public FournisseurDto(String cin) {
        this.cin = cin;
    }

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

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "FournisseurDto{" +
                "cin='" + cin + '\'' +
                ", name='" + name + '\'' +
                ", adresse=" + adresse +
                '}';
    }
}
