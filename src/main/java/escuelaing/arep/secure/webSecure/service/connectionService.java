package escuelaing.arep.secure.webSecure.service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class connectionService {

  final String urlBase = "https://localhost:4567/api/v1/math/";

  static ResponseEntity<String> connect(String url) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    SSLContextBuilder builder = new SSLContextBuilder();
    builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
    SSLConnectionSocketFactory SslCSF = new SSLConnectionSocketFactory(builder.build());
    CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(SslCSF).build();

    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);
    return new RestTemplate(requestFactory).exchange(url, HttpMethod.GET, null, String.class);
  }

  public String sum(String a, String b) throws NoSuchAlgorithmException, KeyStoreException,
      KeyManagementException {
    String url = urlBase + "sum/" + a + "&" + b;
    ResponseEntity<String> result = connect(url);
    return result.getBody();
  }

  public String substrac(String a, String b)
      throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "substrac/" + a + "&" + b;
    ResponseEntity<String> result = connect(url);
    return result.getBody();
  }

  public String multiply(String a, String b)
      throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "multiply/" + a + "&" + b;
    ResponseEntity<String> result = connect(url);
    return result.getBody();
  }

  public String divide(String a, String b) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "divide/" + a + "&" + b;
    ResponseEntity<String> result = connect(url);
    return result.getBody();
  }

  public String square(String a) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "square/" + a;
    ResponseEntity<String> result = connect(url);
    return result.getBody();
  }

  public String exponent(String a, String b)
      throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "exponent/" + a + "&" + b;
    ResponseEntity<String> result = connect(url);
    return result.getBody();
  }

}