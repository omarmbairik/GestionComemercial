package ma.project.services;

import ma.project.models.ProduitDto;
import ma.project.models.ProduitIDDto;

import java.util.List;

public interface ProduitService {
    String create (ProduitDto produitDto);
    String update (ProduitDto produitDto);
    String deletByCodeP (ProduitIDDto produitIDDto);
    List<ProduitDto> selectAll();
    String selectByCodeP(ProduitIDDto produitDto);
    String ajouterListeProduit(List<ProduitDto> produitDtoList);
    List<ProduitDto> selectProduitFilterPrix ();
    String findPtroduitByName(String name);

    String findProduitByCouleur(String couleur);
}
