package barin.com.searchtipsapplication.data.entity;

import com.google.gson.annotations.SerializedName;

public class Tip {

  @SerializedName("id") private String id;
  @SerializedName("createdAt") private long createdAt;
  @SerializedName("text") private String text;
  @SerializedName("user") private User user;

  public Tip() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override public String toString() {
    return "Tip{" +
        "id='" + id + '\'' +
        ", createdAt=" + createdAt +
        ", text='" + text + '\'' +
        ", user=" + user +
        '}';
  }
}
