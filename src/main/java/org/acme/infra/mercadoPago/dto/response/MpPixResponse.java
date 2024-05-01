package org.acme.infra.mercadoPago.dto.response;

import jakarta.json.bind.annotation.JsonbProperty;
import org.acme.infra.mercadoPago.dto.request.MpPixPoiDTO;

public class MpPixResponse {

  @JsonbProperty("point_of_interaction")
  private MpPixPoiDTO poi;

  public MpPixPoiDTO getPoi() {
    return poi;
  }

  public void setPoi(MpPixPoiDTO poi) {
    this.poi = poi;
  }

}