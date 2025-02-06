package umc.th.juinjang.monitoring;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.stream.Collectors;
import org.springframework.web.util.ContentCachingRequestWrapper;

public class ApiLogRequestLogGenerator extends ApiLogGenerator {

  private final ContentCachingRequestWrapper request;

  public ApiLogRequestLogGenerator(ContentCachingRequestWrapper request) {
    this.request = request;
  }

  @Override
  public String generateLog() {
    StringBuilder logBuilder = new StringBuilder();

    logBuilder.append("Request : ").append(" ");
    logBuilder.append(getBaseLogInfo());
    logBuilder.append("[method] ").append(request.getMethod()).append(" ");
    logBuilder.append("[uri] ").append(getQuery()).append(" ");
    logBuilder.append("[headers] ").append(getHeadersAsString(request)).append(" ");
    logBuilder.append("[requestBody] ").append(getBody(request.getContentAsByteArray())).append(" ");

    return logBuilder.toString();
  }

  private String getQuery() {
    String uri = request.getRequestURI();
    String queryString = request.getQueryString();

    if (queryString != null) {
      uri += "?" + queryString;
    }
    return uri;
  }

  private String getHeadersAsString(HttpServletRequest request) {
    return Collections.list(request.getHeaderNames()).stream()
        .filter(headerName -> !headerName.equalsIgnoreCase("Authorization"))
        .filter(headerName -> !headerName.equalsIgnoreCase("refresh-token"))
        .map(headerName -> headerName + "=" + request.getHeader(headerName))
        .collect(Collectors.joining(", "));
  }

  protected String getBody(byte[] info) {
    return new String(info, StandardCharsets.UTF_8).replace("\n", "").replace("\r", "");
  }
}
