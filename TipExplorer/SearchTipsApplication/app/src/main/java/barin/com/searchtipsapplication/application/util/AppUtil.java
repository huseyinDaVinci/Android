package barin.com.searchtipsapplication.application.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * provide with utilizing for simple check and operations.
 */
public final class AppUtil {

  public static String dateFormat = "dd-MM-yyyy hh:mm";
  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());

  private AppUtil() {
    throw new IllegalAccessError("no no no  illegal access my friend!!");
  }

  public static <T> T checkForNull(T object, String message) {
    if (object == null) {
      throw new NullPointerException(message);
    }
    return object;
  }

  public static String getReadableDate(long millis) {
    Date date = new Date(millis);
    return simpleDateFormat.format(date);
  }
}
