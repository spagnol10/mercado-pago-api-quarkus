package org.acme.infra.mercadoPago.repositories;

import java.util.UUID;

import org.acme.domain.dto.PixDTO;
import org.acme.domain.repositories.IPixRepository;
import org.acme.infra.mercadoPago.dto.request.MpPixDTO;
import org.acme.infra.mercadoPago.dto.request.MpPixPayerDTO;
import org.acme.infra.mercadoPago.dto.response.MpPixResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MpPixRepository implements IPixRepository {

  @Inject
  @RestClient
  RestClientMp restClient;

  @ConfigProperty(name = "mp.token")
  String mpToken;

  private final String MP_PAYMENT_ID = "pix";

  @Override
  public PixDTO create(PixDTO dto) {
    // Lógica da request para o MP
    String token = "Bearer ".concat(mpToken);
    String idempotencyKey = UUID.randomUUID().toString();

    MpPixPayerDTO payerDTO = new MpPixPayerDTO();
    MpPixDTO pixDTO = new MpPixDTO();
    payerDTO.setEmail(dto.getEmail());

    pixDTO.setAmount(dto.getAmount());
    pixDTO.setDescription(dto.getDescription());
    pixDTO.setPaymentMethodId(MP_PAYMENT_ID);
    pixDTO.setPayer(payerDTO);

    MpPixResponse response = restClient.createPix(token, idempotencyKey, pixDTO);

    dto.setEmv(response.getPoi().getTrxData().getEmv());
    dto.setBase64(response.getPoi().getTrxData().getBase64());

    return dto;
  }

}
