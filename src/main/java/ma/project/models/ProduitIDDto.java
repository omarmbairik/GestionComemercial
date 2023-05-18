package ma.project.models;

public class ProduitIDDto {
    private Long codeP;
    private String serie;

    public ProduitIDDto() {
    }

    public ProduitIDDto(Long codeP, String serie) {
        this.codeP = codeP;
        this.serie = serie;
    }

    public Long getCodeP() {
        return codeP;
    }

    public void setCodeP(Long codeP) {
        this.codeP = codeP;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "ProduitIDDto{" +
                "codeP=" + codeP +
                ", serie='" + serie + '\'' +
                '}';
    }
}
