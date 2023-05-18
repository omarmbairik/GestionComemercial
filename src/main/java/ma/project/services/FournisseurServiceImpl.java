package ma.project.services;

import ma.project.mappers.FournisseurMapper;
import ma.project.models.FournisseurDto;
import ma.project.repository.FournisseurRepo;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fournisseurService")
public class FournisseurServiceImpl implements FournisseurService{
    public final static Logger LOGGER = LoggerFactory.getLogger(FournisseurServiceImpl.class);
    private FournisseurMapper fournisseurMapper = Mappers.getMapper(FournisseurMapper.class);
    private FournisseurRepo fournisseurRepo;

    public FournisseurServiceImpl(@Qualifier("fournisseurRepo") FournisseurRepo fournisseurRepo) {
        this.fournisseurRepo = fournisseurRepo;
    }

    // Ajouter fournisseur
    @Override
    public String create(FournisseurDto fournisseurDto) {
        LOGGER.debug("Start methode create: {}",fournisseurDto);
        boolean ifExsist =  fournisseurRepo.existsById(fournisseurDto.getCin());
        if(ifExsist == true){
            return "Ce fournisseur {"+fournisseurDto.getCin()+ "} déjat exist !";
        }
        else {
            fournisseurRepo.save(fournisseurMapper.fournisseurDtoToEntity(fournisseurDto));
            return "Le fournisseur {"+fournisseurDto.getCin()+"} est bien ajouté";
        }
    }

    // Modifier fournisseur
    @Override
    public String update(FournisseurDto fournisseurDto) {
        LOGGER.debug("Start methode update: {}",fournisseurDto);
        boolean ifExsist =  fournisseurRepo.existsById(fournisseurDto.getCin());
        if(ifExsist == true){
            fournisseurRepo.save(fournisseurMapper.fournisseurDtoToEntity(fournisseurDto));
            return "Le fournisseur {"+fournisseurDto.getCin()+"} est bien modifié";

        }
        else {
            return "Ce fournisseur {"+fournisseurDto.getCin()+ "} n'exsiste pas !";
        }
    }

    // Supprimer fournisseur par cin
    @Override
    public String deleteByCin(FournisseurDto fournisseurDto) {
        LOGGER.debug("Start methode deletByCin: {}",fournisseurDto);
        boolean results = fournisseurRepo.existsById(fournisseurDto.getCin());
        if(results == true){
            fournisseurRepo.deleteById(fournisseurDto.getCin());
            return "Ce Fournisseur cin: {"+fournisseurDto.getCin()+"} est bien supprimé";
        }
        else {
            return "Ce Fournisseur cin: {"+fournisseurDto.getCin()+"} n'exsiste pas !";
        }
    }

    // Afficher la list des fournisseur
    @Override
    public List<FournisseurDto> selectAll() {
        LOGGER.debug("Start methode selectAll");
        return fournisseurMapper.listFournisseurEntityToDto(fournisseurRepo.findAll());
    }
    // Afficher fournisseur par cin
    @Override
    public String selectByCin(FournisseurDto fournisseurDto) {
        LOGGER.debug("Start methode selectByCin {}", fournisseurDto.getCin());
        FournisseurDto fournisseurDtoExsiste = fournisseurMapper.fournisseuirEntityToDto(fournisseurRepo.findById(fournisseurDto.getCin()).orElse(null));
        if(fournisseurDtoExsiste == null){
            return "Ce fournisseur ñ'existe pas veuillez vérifier le cin de fournisseur, CIN: {"+fournisseurDto.getCin()+"}";
        }
        else {
            LOGGER.debug("tt: {}",fournisseurRepo.findById(fournisseurDto.getCin()).toString());
            return fournisseurDtoExsiste.toString();
        }
    }

    // Ajouter une liste des fournisseur
    @Override
    public String ajouterListeFournisseur(List<FournisseurDto> fournisseurDtoList) {
        LOGGER.debug("Satrt methode ajouterListeFournisseur");
        List<String> fourniseuurExsiste = new ArrayList<String>();
        List<String> fourniseuurNonExsiste = new ArrayList<String>();
        for(FournisseurDto fournisseurDtocin : fournisseurDtoList){
            if (fournisseurRepo.existsById(fournisseurDtocin.getCin()) == true){
                fourniseuurExsiste.add(fournisseurDtocin.getCin());
            }
            else{
                fournisseurRepo.save(fournisseurMapper.fournisseurDtoToEntity(fournisseurDtocin));
                fourniseuurNonExsiste.add(fournisseurDtocin.getCin());
            }
        }
        return "Liste fouriseur ajouter : "+fourniseuurNonExsiste
                +" Liste fournisseur dejat exsist: "+fourniseuurExsiste;
    }


    //Find By Ville
    @Override
    public String findByVille(String ville) {
        LOGGER.debug("Satrt methode findByVille {}",ville);
        List<FournisseurDto> fournisseurDtoList = fournisseurMapper.listFournisseurEntityToDto(fournisseurRepo.findByAdresseVille(ville));
        if (fournisseurDtoList.size() != 0){
            return fournisseurDtoList.toString();
        }
        else {
            return "Aucun Fournisseur  avec cette ville !";
        }
    }
}
