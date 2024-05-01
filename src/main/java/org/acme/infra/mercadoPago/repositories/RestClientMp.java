package org.acme.infra.mercadoPago.repositories;

import org.acme.infra.mercadoPago.dto.request.MpPixDTO;
import org.acme.infra.mercadoPago.dto.response.MpPixResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient(configKey = "base-uri-mp")
public interface RestClientMp {

  @POST
  @Path("/v1/payments")
  @Consumes(MediaType.APPLICATION_JSON)
  MpPixResponse createPix(
      @HeaderParam("Authorization") String token,
      @HeaderParam("X-Idempotency-Key") String idempotency,
      MpPixDTO payload);

}
