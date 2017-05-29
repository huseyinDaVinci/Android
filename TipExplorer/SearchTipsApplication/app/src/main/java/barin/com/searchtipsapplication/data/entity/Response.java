package barin.com.searchtipsapplication.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Response {

  @SerializedName("tips") public List<Tip> tips = new ArrayList<>();

  public Response() {
  }

  public List<Tip> getTips() {
    return tips;
  }

  public void setTips(List<Tip> tips) {
    this.tips = tips;
  }

  @Override public String toString() {
    return "Response{" +
        "tips=" + tips +
        '}';
  }
}
