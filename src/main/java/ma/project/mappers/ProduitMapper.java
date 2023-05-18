package ma.project.mappers;

import ma.project.entities.ProduitEntity;
import ma.project.entities.ProduitIDEntity;
import ma.project.models.ProduitDto;
import ma.project.models.ProduitIDDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProduitMapper {
    ProduitEntity produitDtoToEntity(ProduitDto produitDto);
    ProduitDto produitEntityToDto(ProduitEntity produitEntity);
    List<ProduitEntity> listProduitDtoToEntity (List<ProduitDto> produitDtoList);
    List<ProduitDto> listProduitEntityToDto (List<ProduitEntity> produitEntityList);

    ProduitIDEntity idProduitDtoToEntity(ProduitIDDto produitIDDto) ;
    ProduitIDDto idProduitEntityToDto(ProduitIDEntity produitIDEntity) ;
    List<ProduitIDEntity> idListeProduitDtoToEntity(List<ProduitIDDto> produitIDDtos);
}
