package ma.project.controllers;

import ma.project.models.FournisseurDto;
import ma.project.services.FournisseurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/fournisseur")
public class FournisseurController {
    public final static Logger LOGGER = LoggerFactory.getLogger(FournisseurController.class);
    private FournisseurService fournisseurService;
    public FournisseurController(@Qualifier("fournisseurService")FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    // Select la list des fournisseur
    @GetMapping("/selectAllFournisseur")
    public List<FournisseurDto> selectAll() {
        LOGGER.debug("start method select All");
        return fournisseurService.selectAll();
    }

    // Select fournisseur par son cin
    @GetMapping("/selectbyCin")
    public String selectByCin(String cin){
        LOGGER.debug("Start methode select by cin: {}",cin);
        FournisseurDto cinFournisseur = new  FournisseurDto(cin);
        return fournisseurService.selectByCin(cinFournisseur);
    }

    // findByVille
    @GetMapping("/findByVille")
    public String findByVille (String ville){
        LOGGER.debug("Start methode select by cin: {}",ville);
        return fournisseurService.findByVille(ville);
    }


    // Ajouter fournisseur
    @PostMapping("/createFournisseur")
    public String create (@RequestBody FournisseurDto fournisseurDto){
        LOGGER.debug("Start methode create: {}", fournisseurDto );
        return fournisseurService.create(fournisseurDto);
    }

    // Ajouter liste des fournisseurs
    @PostMapping("Ajouter liste des fournisseur")
    public String ajouterListeFourniseur(@RequestBody List<FournisseurDto> fournisseurDtoList){
        LOGGER.debug("Start methode AjouterListeFourniseur: {}", fournisseurDtoList );
        return fournisseurService.ajouterListeFournisseur(fournisseurDtoList);
    }

    // modifier fournisseur
    @PutMapping("/updateFournisseur")
    public String update (@RequestBody FournisseurDto fournisseurDto){
        LOGGER.debug("Start methode create: {}", fournisseurDto );
        return fournisseurService.update(fournisseurDto);
    }

    // Supprimer fournisseur par cin
    @DeleteMapping("Delete by CIN")
    public String delete(String cin){
        LOGGER.debug("Start methode delete by cin: {}",cin);
        FournisseurDto fournisseurDto = new FournisseurDto(cin);
        return fournisseurService.deleteByCin(fournisseurDto);
    }
}
