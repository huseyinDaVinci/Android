package barin.com.searchtipsapplication.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Builder pattern can be useful for more params can be added according to user's choice.
 */
public class TParameters implements ITParameters, Parcelable {

  private String ll;   //required
  private String near;  //optional

  int limit;     //optional
  int offset;    //optional

  public static class Builder {
    // Required parameters
    private final String ll;
    // Optional parameters - initialized to default values
    private String near = null;
    private int limit = 0;
    private int offset = 0;

    public Builder(String ll) {
      this.ll = ll;
    }

    public Builder near(String near) {
      this.near = near;
      return this;
    }

    public Builder limit(int limit) {
      this.limit = limit;
      return this;
    }

    public Builder offSet(int offset) {
      this.offset = offset;
      return this;
    }

    public TParameters build() {
      return new TParameters(this);
    }
  }

  private TParameters(Builder builder) {
    this.ll = builder.ll;
    this.near = builder.near;
    this.limit = builder.limit;
    this.offset = builder.offset;
  }

  protected TParameters(Parcel in) {
    ll = in.readString();
    near = in.readString();
    limit = in.readInt();
    offset = in.readInt();
  }

  @Override public String getLL() {
    return ll;
  }

  @Override public void setLL(String ll) {
    this.ll = ll;
  }

  @Override public String getNear() {
    return near;
  }

  @Override public void setNear(String near) {
    this.near = near;
  }

  public static final Creator<TParameters> CREATOR = new Creator<TParameters>() {
    @Override public TParameters createFromParcel(Parcel in) {
      return new TParameters(in);
    }

    @Override public TParameters[] newArray(int size) {
      return new TParameters[size];
    }
  };

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(ll);
    dest.writeString(near);
    dest.writeInt(limit);
    dest.writeInt(offset);
  }
}
