package barin.com.searchtipsapplication.data.net;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * aim is to converting primitive types returning from api.
 */
public class PrimitiveConverterFactory extends Converter.Factory {

  public static PrimitiveConverterFactory create() {
    return new PrimitiveConverterFactory();
  }

  private PrimitiveConverterFactory() {

  }

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
      Retrofit retrofit) {
    if (type == String.class) {
      return ResponseBody::string;
    } else if (type == Integer.class) {
      return value -> Integer.valueOf(value.string());
    } else if (type == Double.class) {
      return value -> Double.valueOf(value.string());
    } else if (type == Boolean.class) {
      return value -> Boolean.valueOf(value.string());
    }
    return null;
  }
}