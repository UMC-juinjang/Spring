package umc.th.juinjang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;

public class LoggerProvider { // 커스텀 로거 생성 메서드

  private static final String REQUEST_ID = "request_id";
  private static final String USER_ID = "user_id";

  public static Logger getLogger(Class<?> clazz) {
    return LoggerFactory.getLogger(clazz);
  }

  public static void registerRequestId(String requestId) {
    MDC.put(REQUEST_ID, requestId);
  }

  public static void registerUserId(String userId) {
    MDC.put(USER_ID, userId);
  }
}
