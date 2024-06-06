package umc.th.juinjang.converter.limjang;

import static umc.th.juinjang.utils.LimjangUtil.makePriceList;
import static umc.th.juinjang.utils.LimjangUtil.makePriceListVersion2;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import umc.th.juinjang.model.dto.limjang.LimjangDetailResponseDTO;
import umc.th.juinjang.model.dto.limjang.LimjangTotalListResponseDTO;
import umc.th.juinjang.model.dto.limjang.enums.LimjangCheckListVersionEnum;
import umc.th.juinjang.model.entity.Image;
import umc.th.juinjang.model.entity.Limjang;
import umc.th.juinjang.model.entity.LimjangPrice;
import umc.th.juinjang.model.entity.enums.LimjangPriceType;
import umc.th.juinjang.model.entity.enums.LimjangPropertyType;
import umc.th.juinjang.model.entity.enums.LimjangPurpose;

public class LimjangDetailConverter {

  public static LimjangDetailResponseDTO.DetailDto toDetail(
      Limjang limjang, LimjangPrice limjangPrice) {

    List<String> urlList = limjang.getImageList().stream()
        .sorted(Comparator.comparing(Image::getCreatedAt)) // createdAt 기준으로 정렬
        .map(Image::getImageUrl)
        .limit(3)
        .toList();

    LimjangPurpose purposeType = limjang.getPurpose();
    LimjangPropertyType propertyType = limjang.getPropertyType();
    LimjangPriceType priceType = limjang.getPriceType();

    LimjangCheckListVersionEnum checkListVersion;
    if (purposeType == LimjangPurpose.RESIDENTIAL_PURPOSE &&
        (propertyType == LimjangPropertyType.VILLA||
            propertyType == LimjangPropertyType.OFFICE_TEL)
    ){
      checkListVersion = LimjangCheckListVersionEnum.NON_LIMJANG;
    } else {
      checkListVersion = LimjangCheckListVersionEnum.LIMJANG;
    }

    List<String> priceList = makePriceListVersion2(priceType, purposeType,limjangPrice);

    return LimjangDetailResponseDTO.DetailDto.builder()
        .limjangId(limjang.getLimjangId())
        .checkListVersion(checkListVersion)
        .images(urlList)
        .nickname(limjang.getNickname())
        .purposeCode(limjang.getPurpose().getValue())
        .priceType(priceType.getValue())
        .priceList(priceList)
        .address(limjang.getAddress())
        .addressDetail(limjang.getAddressDetail())
        .createdAt(limjang.getCreatedAt())
        .updatedAt(limjang.getUpdatedAt())
        .build();
  }
}
