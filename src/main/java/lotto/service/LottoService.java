package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.common.enums.LottoRank;
import lotto.common.utils.NumberUtil;
import lotto.domain.Lotto;

public class LottoService {
  private static LottoService lottoService = new LottoService();

  private LottoService() {
  }

  public static LottoService getInstance() {
    return lottoService;
  }

  public List<Lotto> purchaseLottos(int purchaseAmount) {
    int numberOfLottos = purchaseAmount / NumberUtil.LOTTO_PRICE;
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < numberOfLottos; i++) {
      lottos.add(Lotto.generate());
    }

    return lottos;
  }

  public LottoRank winningCheck(List<Integer> userNumbers, List<Integer> winningNumbers, int bonusNumber) {
    int matchCount = (int) userNumbers.stream()
        .filter(winningNumbers::contains)
        .count();

    boolean matchBonus = userNumbers.contains(bonusNumber);
    return LottoRank.valueOf(matchCount, matchBonus);
  }

}
