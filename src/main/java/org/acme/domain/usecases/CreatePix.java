package org.acme.domain.usecases;

import org.acme.domain.dto.PixDTO;
import org.acme.domain.entities.PixBO;
import org.acme.domain.mappers.PixMapper;
import org.acme.domain.repositories.IPixRepository;

public class CreatePix {
  private IPixRepository pixRepository;

  public CreatePix(IPixRepository pixRepository) {
    this.pixRepository = pixRepository;
  }

  public PixDTO execute(PixDTO pixDTO) {
    PixBO bo = PixMapper.toBO(pixDTO);

    PixDTO createdPix = pixRepository.create(pixDTO);

    bo.updateEmvData(createdPix.getEmv(), createdPix.getBase64(), createdPix.getExpiration());

    return createdPix;
  }

}
