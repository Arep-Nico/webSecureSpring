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

  static ResponseEntity<Double> connect(String url) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    SSLContextBuilder builder = new SSLContextBuilder();
    builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
    SSLConnectionSocketFactory SslCSF = new SSLConnectionSocketFactory(builder.build());
    CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(SslCSF).build();

    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);
    return new RestTemplate(requestFactory).exchange(url, HttpMethod.GET, null, Double.class);
  }

  public Double sum(Double a, Double b) throws NoSuchAlgorithmException, KeyStoreException,
      KeyManagementException {
    String url = urlBase + "sum/" + a + "&" + b;

    ResponseEntity<Double> result = connect(url);

    return result.getBody();
  }

  public Double substrac(Double a, Double b)
      throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "substrac/" + a + "&" + b;
    ResponseEntity<Double> result = connect(url);
    return result.getBody();
  }

  public Double multiply(Double a, Double b)
      throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "multiply/" + a + "&" + b;
    ResponseEntity<Double> result = connect(url);
    return result.getBody();
  }

  public Double divide(Double a, Double b) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "divide/" + a + "&" + b;
    ResponseEntity<Double> result = connect(url);
    return result.getBody();
  }

  public Double square(Double a) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "square/" + a;
    ResponseEntity<Double> result = connect(url);
    return result.getBody();
  }

  public Double exponent(Double a, Double b)
      throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    String url = urlBase + "exponent/" + a + "&" + b;
    ResponseEntity<Double> result = connect(url);
    return result.getBody();
  }

}