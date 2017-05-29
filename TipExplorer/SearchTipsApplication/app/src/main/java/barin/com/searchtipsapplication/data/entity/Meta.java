package barin.com.searchtipsapplication.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

  @SerializedName("code") @Expose private int code;
  @SerializedName("requestId") @Expose private String requestId;

  public Meta() {

  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }
}
