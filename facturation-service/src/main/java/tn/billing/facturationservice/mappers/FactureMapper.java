package tn.billing.facturationservice.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.billing.facturationservice.dto.FactureDto;
import tn.billing.facturationservice.entities.Facture;

@Mapper(componentModel = "spring")
public interface FactureMapper {

    FactureDto mapToDto(Facture f);
    Facture mapToEntity(FactureDto dto);

}
