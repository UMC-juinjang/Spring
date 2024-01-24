package umc.th.juinjang.model.dto.google;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KakaoOauthToken {
    // 응답 객체가 JSON 형식으로 되어 있으므로, 이를 deserialization 해서 자바 객체에 담음
    // -> 여기서 자바 객체에 해당하는 클래스
    private String token_type;
    private String access_token;
    private String id_token;
    private int expires_in;
    private String refresh_token;
    private String refresh_token_expires_in;
    private String scope;
}
