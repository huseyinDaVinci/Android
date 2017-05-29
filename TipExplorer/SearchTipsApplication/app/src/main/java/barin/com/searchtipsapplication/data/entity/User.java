package barin.com.searchtipsapplication.data.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

  @SerializedName("id") @Expose private String id;
  @SerializedName("firstName") @Expose private String firstName;
  @SerializedName("lastName") @Expose private String lastName;
  @SerializedName("gender") @Expose private String gender;

  public User() {
  }

  protected User(Parcel in) {
    id = in.readString();
    firstName = in.readString();
    lastName = in.readString();
    gender = in.readString();
  }

  public static final Creator<User> CREATOR = new Creator<User>() {
    @Override public User createFromParcel(Parcel in) {
      return new User(in);
    }

    @Override public User[] newArray(int size) {
      return new User[size];
    }
  };

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGender() {
    return gender;
  }

  @Override public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", gender='" + gender + '\'' +
        '}';
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(id);
    dest.writeString(firstName);
    dest.writeString(lastName);
    dest.writeString(gender);
  }
}
