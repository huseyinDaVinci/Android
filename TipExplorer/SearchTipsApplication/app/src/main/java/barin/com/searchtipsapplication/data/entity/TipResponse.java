package barin.com.searchtipsapplication.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public class TipResponse implements ITipResponse {

  @SerializedName("meta") private Meta meta;
  @SerializedName("response") private Response response;

  public TipResponse() {
  }

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  @Override public String toString() {
    return "TipResponse{" +
        "response=" + response +
        '}';
  }

  @Override public List<Tip> getTips() {
    if (response.tips != null) {
      return response.tips;
    }
    return Collections.emptyList();
  }
}



