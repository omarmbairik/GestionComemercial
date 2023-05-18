package ma.project.repository;

import ma.project.entities.FournisseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fournisseurRepo")
public interface FournisseurRepo extends JpaRepository<FournisseurEntity, String> {
    public List<FournisseurEntity> findByAdresseVille (String ville);
}
