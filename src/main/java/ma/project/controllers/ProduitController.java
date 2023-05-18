package ma.project.controllers;

import ma.project.models.ProduitDto;
import ma.project.models.ProduitIDDto;
import ma.project.services.ProduitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/produit")
public class ProduitController {
    public final static Logger LOGGER = LoggerFactory.getLogger(ProduitController.class);
    private ProduitService produitService;

    public ProduitController(@Qualifier("produitService") ProduitService produitService) {
        this.produitService = produitService;
    }

    // Select la list des produit
    @GetMapping("/SelectAllProduit")
    public List<ProduitDto> selectAll(){
        LOGGER.debug("Start methode selectAll");
        return produitService.selectAll();
    }

    // Select Produit par son ID
    @GetMapping("SelectByCodeP")
    public String selectByCodeP(Long codeP, String serial){
        LOGGER.debug("Start methode selectByCodeP: {}",codeP,serial);
        ProduitIDDto produitIDDto = new ProduitIDDto(codeP,serial);
        return produitService.selectByCodeP(produitIDDto);
    }


    // Select Produit par couleur
    @GetMapping("findProduitByCouleur")
    public String findProduitByCouleur (String couleur){
        LOGGER.debug("Start methode findProduitByCouleur: {}",couleur);
        return produitService.findProduitByCouleur(couleur);
    }

    //Select des produit prix >=38
    @GetMapping("SelectParPrix>=38")
    public List<ProduitDto> selectParPrix(){
        LOGGER.debug("Start methode selectAll");
        return produitService.selectProduitFilterPrix();
    }

    // select produit par nom
    @GetMapping("/findPtroduitByName")
    public String findPtroduitByName(String name){
        LOGGER.debug("Start methode findPtroduitByName", name);
        return produitService.findPtroduitByName(name);
    }

    // Ajouter produit
    @PostMapping("AjouterProduit")
    public String create (@RequestBody ProduitDto produitDto){
        LOGGER.debug("Start methode create: {}", produitDto);
        return produitService.create(produitDto);
    }

    // Ajouter liste des produits
    @PostMapping("AjouterListeProduits")
    public String ajouterListeProduits(@RequestBody List<ProduitDto> produitDtoList){
        LOGGER.debug("Start methode: {}", produitDtoList);
        return produitService.ajouterListeProduit(produitDtoList);
    }

    // Modifier produit
    @PutMapping("ModifierProduit")
    public String update(@RequestBody ProduitDto produitDto){
        LOGGER.debug("Start methode update: {}",produitDto);
        return  produitService.update(produitDto);
    }

    // Supprimer produit
    @DeleteMapping("DeleteProduit")
    public String deleteByCodeP(Long codeP, String serial){
        LOGGER.debug("Start methode deleteByCodeP: {}",codeP,serial);
        ProduitIDDto produitIDDto = new ProduitIDDto(codeP,serial);
        return produitService.deletByCodeP(produitIDDto);
    }

}
