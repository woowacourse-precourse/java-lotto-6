package lotto.domain;

import java.util.List;

public class LottoList {
  private final List<Lotto> lottoList;

  public LottoList(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public List<Lotto> getLottolist() {
    return lottoList;
  }
}