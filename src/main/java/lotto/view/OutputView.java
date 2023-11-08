package lotto.view;

import java.util.List;
import lotto.model.data.Lotto;

public interface OutputView {
  void printIntroduction(String introduction);

  void printResultOfBuy(Integer amountOfLotto);

  void printLottos(List<Lotto> purchasedLottos);

  void printNotBonusPrize(Integer prize, Integer count);

  void printBonusPrize(Integer prize, Integer count);

  void printRateOfReturn(Double rateOfReturn);
}
