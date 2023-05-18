package ma.project.services;

import ma.project.mappers.ProduitMapper;
import ma.project.models.ProduitDto;
import ma.project.models.ProduitIDDto;
import ma.project.repository.ProduitRepo;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("produitService")
public class ProduitServiceImpl implements ProduitService{

    public final static Logger LOGGER = LoggerFactory.getLogger(ProduitServiceImpl.class);
    private ProduitMapper produitMapper = Mappers.getMapper(ProduitMapper.class);
    private ProduitRepo produitRepo;

    public ProduitServiceImpl(@Qualifier("produitRepo") ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    // Ajouter produit
    @Override
    public String create(ProduitDto produitDto) {
        LOGGER.debug("Start methode create:", produitDto);
        boolean ifExsist = produitRepo.existsById(produitMapper.idProduitDtoToEntity(produitDto.getProduitID()));
        if (ifExsist == true){
            return "Ce produit {"+produitDto.getProduitID()+ "} déjat exist !";
        }
        else {
            produitRepo.save(produitMapper.produitDtoToEntity(produitDto));
            return "Le produit {"+produitDto.getProduitID()+"} est bien ajouté";
        }
    }

    // Modifier produit
    @Override
    public String update(ProduitDto produitDto) {
        LOGGER.debug("Start methode update: ",produitDto);
        boolean ifExsist = produitRepo.existsById(produitMapper.idProduitDtoToEntity(produitDto.getProduitID()));
        if (ifExsist == true){
            produitRepo.save(produitMapper.produitDtoToEntity(produitDto));
            return "Le produit {"+produitDto.getProduitID()+"} est bien modifié";
        }
        else {
            return "Ce produit {"+produitDto.getProduitID()+"} n'exsiste pas !";
        }
    }

    // Supprimer produit par id
    @Override
    public String deletByCodeP(ProduitIDDto produitIDDto) {
        LOGGER.debug("Start methode deletByCodeP: ",produitIDDto);
        boolean ifExsist = produitRepo.existsById(produitMapper.idProduitDtoToEntity(produitIDDto));
        if (ifExsist == true){
            produitRepo.deleteById(produitMapper.idProduitDtoToEntity(produitIDDto));
            return "Ce produit Code: {"+produitIDDto.getCodeP()+
                    "}, Serial{"+produitIDDto.getSerie()+"} est bien supprimé";
        }
        else {
            return "Ce produit Code: {"+produitIDDto.getCodeP()+
                    "}, Serial{"+produitIDDto.getSerie()+"} n'exsiste pas !";
        }
    }

    // Afficher la list des produit
    @Override
    public List<ProduitDto> selectAll() {
        LOGGER.debug("Start methode selectAll");
        return produitMapper.listProduitEntityToDto(produitRepo.findAll());
    }
    // Afficher produit par id
    @Override
    public String selectByCodeP(ProduitIDDto produitIDDto) {
        LOGGER.debug("Start methode selectByCodeP: {}",produitIDDto);
        ProduitDto results = produitMapper.produitEntityToDto(produitRepo.findById(produitMapper.idProduitDtoToEntity(produitIDDto)).orElse(null));
        if(results == null){
            return "Ce produit ñ'existe pas veuillez vérifier le code de produit, avec CodeP {"+produitIDDto.getCodeP()+"} et Serial{"+produitIDDto.getSerie()+"}";
        }
        else {
            return results.toString();
        }
    }

    // Ajouter une liste des produit
    @Override
    public String ajouterListeProduit(List<ProduitDto> produitDtoList) {
        LOGGER.debug("Start methode ajouterListeProduit {}", produitDtoList);
        List<String> produitExsist = new ArrayList<String>();
        List<String> produitNoExsist = new ArrayList<String>();
        for (ProduitDto produitDtoCodeP: produitDtoList){
            if(produitRepo.existsById(produitMapper.idProduitDtoToEntity(produitDtoCodeP.getProduitID())) == true){
                produitExsist.add(produitDtoCodeP.getProduitID().toString());
            }
            else {
                produitRepo.saveAll(produitMapper.listProduitDtoToEntity(produitDtoList));
                produitNoExsist.add(produitDtoCodeP.getProduitID().toString());
            }
        }
        return "Liste des produits ajouter : " + produitNoExsist
                + " Liste des produits dejat exsist: " + produitExsist;
    }

    // Liste des produit par couleur
    @Override
    public String findProduitByCouleur(String couleur) {
        LOGGER.debug("Start methode findProduitByCouleur {}", couleur);
        List<ProduitDto> produitDtoList = produitMapper.listProduitEntityToDto(produitRepo.findByCouleur(couleur));
        if(produitDtoList.size()!= 0){
            return produitDtoList.toString();
        }
        else {
            return "Aucun produit avec ce couleur !";
        }
    }

    // Liste des produit prix >=38
    @Override
    public List<ProduitDto> selectProduitFilterPrix() {
        LOGGER.debug("Start methode selectProduitFilterPrix");
        List<ProduitDto> produitDtoList = produitMapper.listProduitEntityToDto(produitRepo.findAll());
        return produitDtoList.stream().filter(x-> x.getPrix()>= 38).collect(Collectors.toList());
    }

    // select produit par nom
    @Override
    public String findPtroduitByName(String name) {
        LOGGER.debug("Start methode findPtroduitByName {}", name);
        List<ProduitDto> dtoList = produitMapper.listProduitEntityToDto(produitRepo.findByName(name));
        if(dtoList.size()!= 0){
            return dtoList.toString();
        }
        else {
            return "Aucun produit avec ce nom !";
        }
    }
}
