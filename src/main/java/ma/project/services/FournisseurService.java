package ma.project.services;

import ma.project.models.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    String create(FournisseurDto fournisseurDto);
    String update (FournisseurDto fournisseurDto);
    String deleteByCin (FournisseurDto fournisseurDto);
    List<FournisseurDto> selectAll();
    String selectByCin(FournisseurDto fournisseurDto);
    String ajouterListeFournisseur (List<FournisseurDto> fournisseurDtoList);
    String findByVille(String ville);
}
