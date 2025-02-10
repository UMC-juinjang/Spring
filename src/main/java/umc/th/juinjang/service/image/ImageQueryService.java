package umc.th.juinjang.service.image;

import umc.th.juinjang.model.dto.image.ImagesGetResponse;

public interface ImageQueryService {
  ImagesGetResponse getImageList(long limjangId);
}
