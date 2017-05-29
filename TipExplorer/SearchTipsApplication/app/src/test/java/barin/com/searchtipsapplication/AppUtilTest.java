package barin.com.searchtipsapplication;

import barin.com.searchtipsapplication.application.util.AppUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by machiavelli on 6/24/2016.
 */
public class AppUtilTest {

  @Rule public ExpectedException exception = ExpectedException.none();

  @Test public void testCheckForNull() {
    exception.expect(NullPointerException.class);
    exception.expectMessage("test==null");
    AppUtil.checkForNull(null, "test==null");
  }

  @Test public void testGetReadableDate() {
    String actual = AppUtil.getReadableDate(1328899281);
    String expected = "16-01-1970 11:08";
    // use this method because float is not precise
    assertEquals("Wrong Type of date", expected, actual);
  }
}
