package ma.project.repository;

import ma.project.entities.ProduitEntity;
import ma.project.entities.ProduitIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("produitRepo")
public interface ProduitRepo extends JpaRepository<ProduitEntity, ProduitIDEntity> {
    public List<ProduitEntity> findByName (String name);
    public List<ProduitEntity> findByCouleur (String couleur);
}
