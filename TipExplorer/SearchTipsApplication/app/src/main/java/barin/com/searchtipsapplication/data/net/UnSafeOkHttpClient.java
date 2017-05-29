package barin.com.searchtipsapplication.data.net;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/**
 * Intentionally created for testing purpose SSL implementation was not added.
 */
public class UnSafeOkHttpClient {

  public static OkHttpClient getUnsafeOkHttpClient() {

    try {
      // Create a trust manager that does not validate certificate chains
      final TrustManager[] trustAllCerts = new TrustManager[] {
          new X509TrustManager() {
            @Override public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                String authType) throws CertificateException {

            }

            @Override public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                String authType) throws CertificateException {
            }

            @Override public java.security.cert.X509Certificate[] getAcceptedIssuers() {
              return new X509Certificate[0];
            }
          }
      };

      // Install the all-trusting trust manager
      final SSLContext sslContext = SSLContext.getInstance("SSL");
      sslContext.init(new KeyManager[] {}, trustAllCerts, new java.security.SecureRandom());
      // Create an ssl socket factory with our all-trusting manager
      final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      builder.sslSocketFactory(sslSocketFactory);
      builder.hostnameVerifier((hostname, session) -> true);

      OkHttpClient okHttpClient = builder.build();
      return okHttpClient;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}