package lotto.view;

import java.util.List;
import lotto.model.data.Lotto;
import lotto.model.data.WinningPortfolio;

public interface OutputView {
  void printIntroduction(String introduction);

  void printException(String exceptionMessage);

  void printLottos(List<Lotto> purchasedLottos);

  void printWinningStatistics(WinningPortfolio winningPortfolio);

  void printRateOfReturn(Double rateOfReturn);
}
