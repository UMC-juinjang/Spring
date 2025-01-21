package umc.th.juinjang.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import umc.th.juinjang.apiPayload.ApiResponse;
import umc.th.juinjang.apiPayload.code.status.SuccessStatus;
import umc.th.juinjang.model.dto.image.ImageDeleteRequestDTO;
import umc.th.juinjang.model.dto.image.ImageListResponseDTO;
import umc.th.juinjang.service.image.ImageCommandService;
import umc.th.juinjang.service.image.ImageQueryService;
import umc.th.juinjang.service.limjang.LimjangCommandService;

@RestController
@RequestMapping("/api/limjang/image")
@RequiredArgsConstructor
@Validated
public class ImageController {

  private final LimjangCommandService limjangCommandService;
  private final ImageCommandService imageCommandService;
  private final ImageQueryService imageQueryService;

   @CrossOrigin
   @Operation(summary = "사진 생성 API", description = "사진 업로드 api입니다.")
   @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
       produces = MediaType.APPLICATION_JSON_VALUE)
  public ApiResponse uploadImages(
   @RequestParam(name = "limjangId") Long limjangId, @RequestPart(name = "images") List<MultipartFile> images)
    {
      imageCommandService.uploadImages(limjangId ,images);
      return ApiResponse.onSuccess(SuccessStatus.IMAGE_UPDATE);
    }

  @CrossOrigin
  @Operation(summary = "사진 조회 API", description = "사진을 조회하는 api입니다.")
  @GetMapping(value = "{limjangId}")
  public ApiResponse<ImageListResponseDTO.ImagesListDTO> uploadImages(
      @PathVariable(name = "limjangId") @Valid  Long limjangId)
  {
    return ApiResponse.onSuccess(imageQueryService.getImageList(limjangId));
  }

  @CrossOrigin
  @Operation(summary = "이미지 선택 삭제", description = "이미지 게시글을 여러 개 선택해서 삭제하는 api입니다.")
  @PostMapping("/delete")
  public ApiResponse deleteImage(@RequestBody @Valid ImageDeleteRequestDTO.DeleteDto deleteIds
  ){

    imageCommandService.deleteImages(deleteIds);
    return ApiResponse.onSuccess(SuccessStatus.IMAGE_DELETE);
  }

}
