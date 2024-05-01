package org.acme.infra.mercadoPago.dto.request;

import org.acme.infra.mercadoPago.dto.response.MpPixResponseTrxData;

import jakarta.json.bind.annotation.JsonbProperty;

public class MpPixPoiDTO {

  @JsonbProperty("transaction_data")
  private MpPixResponseTrxData trxData;

  public MpPixResponseTrxData getTrxData() {
    return trxData;
  }

  public void setTrxData(MpPixResponseTrxData trxData) {
    this.trxData = trxData;
  }

}
