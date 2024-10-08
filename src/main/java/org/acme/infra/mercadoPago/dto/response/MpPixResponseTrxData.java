package org.acme.infra.mercadoPago.dto.response;

import jakarta.json.bind.annotation.JsonbProperty;

public class MpPixResponseTrxData {

  @JsonbProperty("qr_code")
  private String emv;

  @JsonbProperty("qr_code_base64")
  private String base64;

  public String getEmv() {
    return emv;
  }

  public void setEmv(String emv) {
    this.emv = emv;
  }

  public String getBase64() {
    return base64;
  }

  public void setBase64(String base64) {
    this.base64 = base64;
  }

}
