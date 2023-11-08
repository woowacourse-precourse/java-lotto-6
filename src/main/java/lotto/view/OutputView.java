package lotto.view;

import lotto.dto.Result;
import lotto.model.MyLotto;

public interface OutputView {

  void printEmptyLine();

  void printErrorMessage(IllegalArgumentException exception);

  void printPurchasedMessage(MyLotto myLotto);

  void printPurchasedMyLottoList();

  void printWinningStatistics();

  void printSeparator();

  void printWinningStatisticsSummary(Result result);
}
