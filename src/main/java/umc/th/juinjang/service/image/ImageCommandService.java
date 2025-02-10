package umc.th.juinjang.service.image;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import umc.th.juinjang.model.dto.image.ImageDeleteRequestDTO;

public interface ImageCommandService {
    void createImages(long limjangId, List<MultipartFile> images);

    void deleteImages(ImageDeleteRequestDTO.DeleteDto ids);

}
