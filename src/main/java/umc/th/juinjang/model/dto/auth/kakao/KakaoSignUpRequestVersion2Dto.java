package umc.th.juinjang.model.dto.auth.kakao;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KakaoSignUpRequestVersion2Dto {

    @NotEmpty
    private String email;
    private String kakaoNickname;
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String agreeVersion;
}
