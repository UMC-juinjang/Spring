package umc.th.juinjang.model.dto.google;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KakaoUser {
    // 다시 JSON 형식의 응답 객체를 deserialization 해서 자바 객체에 담음
    // -> 여기서 자바 객체에 해당하는 클래스
    private Long id;
    private KakaoAccount kakao_account;

    @Data
    private class KakaoAccount {
        private String email;
        public Boolean profile_nickname_needs_agreement;
        public Profile profile;

        @Data
        public class Profile {
            public String nickname;
        }

    }
}
