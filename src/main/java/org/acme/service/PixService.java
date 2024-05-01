package org.acme.service;

import org.acme.domain.dto.PixDTO;
import org.acme.domain.usecases.CreatePix;
import org.acme.infra.mercadoPago.repositories.MpPixRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixService {
  
  @Inject
  MpPixRepository mpPixRepository;

  public PixDTO generatePix(PixDTO dto){

    CreatePix createPix = new CreatePix(mpPixRepository);
    
    return createPix.execute(dto);
  }
}
