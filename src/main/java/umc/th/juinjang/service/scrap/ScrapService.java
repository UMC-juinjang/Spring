package umc.th.juinjang.service.scrap;

import umc.th.juinjang.model.entity.Member;

public interface ScrapService {

  void createScrap(Member member, long limjangId);

  void deleteScrap(Member member, long limjangId);
}
