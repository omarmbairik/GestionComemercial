package ma.project.mappers;

import ma.project.entities.FournisseurEntity;
import ma.project.models.FournisseurDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FournisseurMapper {
    public FournisseurEntity fournisseurDtoToEntity (FournisseurDto fournisseurDto);
    public FournisseurDto fournisseuirEntityToDto (FournisseurEntity fournisseurEntity);
    public List<FournisseurEntity> listFournisseurDtoToEntity (List<FournisseurDto> listFournisseurDto);
    public List<FournisseurDto> listFournisseurEntityToDto (List<FournisseurEntity> listFournisseurEntity);
}
