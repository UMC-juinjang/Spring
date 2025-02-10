package umc.th.juinjang.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.th.juinjang.model.entity.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Image extends BaseEntity {

  @Id
  @Column(name="image_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long imageId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "limjang_id")
  private Limjang limjangId;

  @Lob
  @Column(nullable = false)
  private String imageUrl;

  public static Image create(String imageUrl, Limjang limjang) {
    return Image.builder()
        .imageUrl(imageUrl)
        .limjangId(limjang)
        .build();
  }
}
