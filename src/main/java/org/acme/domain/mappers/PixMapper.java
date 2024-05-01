package org.acme.domain.mappers;

import org.acme.domain.dto.PixDTO;
import org.acme.domain.entities.PixBO;

public class PixMapper {

  public static PixDTO toDTO(PixBO bo) {
    PixDTO dto = new PixDTO();

    dto.setId(bo.getId().toString());
    dto.setAmount(bo.getAmount());
    dto.setEmail(bo.getEmail());
    dto.setDescription(bo.getDescription());
    dto.setBase64(bo.getBase64());
    dto.setExpiration(bo.getExpiration());

    return dto;
  }

  public static PixBO toBO(PixDTO dto) {
    return new PixBO(
        dto.getId(),
        dto.getAmount(),
        dto.getEmail(),
        dto.getDescription(),
        dto.getEmv(),
        dto.getBase64(),
        dto.getExpiration());
  }
  
}
