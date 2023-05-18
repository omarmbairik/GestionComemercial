package ma.project.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProduitIDEntity implements Serializable {
    private Long codeP;
    private String serie;

    public ProduitIDEntity() {
    }

    public ProduitIDEntity(Long codeP, String serie) {
        this.codeP = codeP;
        this.serie = serie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduitIDEntity)) return false;
        ProduitIDEntity that = (ProduitIDEntity) o;
        return codeP.equals(that.codeP) && serie.equals(that.serie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeP, serie);
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
}
