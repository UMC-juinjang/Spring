package umc.th.juinjang.service.image;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import umc.th.juinjang.apiPayload.code.status.ErrorStatus;
import umc.th.juinjang.apiPayload.exception.handler.LimjangHandler;
import umc.th.juinjang.model.dto.image.ImageDeleteRequestDTO;
import umc.th.juinjang.model.entity.Image;
import umc.th.juinjang.model.entity.Limjang;
import umc.th.juinjang.repository.image.ImageRepository;
import umc.th.juinjang.repository.limjang.LimjangRepository;
import umc.th.juinjang.service.external.S3Service;

@Service
@RequiredArgsConstructor
public class ImageCommandServiceImpl implements ImageCommandService {

  private final ImageRepository imageRepository;
  private final LimjangRepository limjangRepository;
  private final S3Service s3Service;
  private final String DIR_NAME = "image";

  @Override
  @Transactional
  public void createImages(final long limjangId, final List<MultipartFile> files) {
    Limjang limjang = getLimjangById(limjangId);
    for (MultipartFile file : files) {
      String imageUrl = s3Service.upload(file, DIR_NAME);
      imageRepository.save(Image.create(imageUrl, limjang));
    }
  }

  private Limjang getLimjangById(final long limjangId) {
    return limjangRepository.findById(limjangId).orElseThrow(()-> new LimjangHandler(ErrorStatus.LIMJANG_NOTFOUND_ERROR));
  }

  @Override
  @Transactional
  public void deleteImages(final ImageDeleteRequestDTO.DeleteDto ids) {
    List<Image> images = imageRepository.findAllById(ids.getImageIdList());
    for (Image image : images) {
      s3Service.deleteFile(image.getImageUrl());
      imageRepository.deleteById(image.getImageId());
    }
  }
}
