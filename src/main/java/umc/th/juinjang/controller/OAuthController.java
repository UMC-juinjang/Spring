package umc.th.juinjang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.th.juinjang.model.dto.LoginResponseDto;
import umc.th.juinjang.service.OAuthService.OAuthService;
import umc.th.juinjang.apiPayload.ApiResponse;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class OAuthController {
    private final OAuthService oauthService;

    // 카카오 로그인
    // 사용자 로그인 페이지 제공 단계 - url
    @GetMapping(value="/{socialLoginType}")
    public void socialLoginType(@PathVariable(name="socialLoginType") String socialLoginType) throws IOException {
//        oauthService.request(socialLoginType);
    }

    // code -> accessToken 받아오기
    // accessToken -> 사용자 정보 받아오기
    @GetMapping(value="/{socialLoginType}/callback")
    public ApiResponse<LoginResponseDto> callback(
            @PathVariable(name="socialLoginType") String socialLoginType,
            @RequestParam(name="code") String code) throws JsonProcessingException {

//        LoginResponseDto result = oauthService.oauthLogin(socialLoginType, code);
//        return ApiResponse.onSuccess(result);
        return null;
    }
}
