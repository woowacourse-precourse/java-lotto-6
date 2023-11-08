package lotto.view;

import java.util.List;
import lotto.model.data.Lotto;
import lotto.model.data.WinningPortfolio;

/**
 * 출력을 하는 View의 interface다.
 */
public interface OutputView {
  /**
   * 안내 문구를 출력한다.
   *
   * @param introduction 안내 문구
   */
  void printIntroduction(String introduction);

  /**
   * 예외 메시지를 출력한다.
   *
   * @param exceptionMessage 예외 메시지
   */
  void printException(String exceptionMessage);

  /**
   * 로또 번호를 출력한다.
   *
   * @param purchasedLottos 출력할 로또들
   */
  void printLottos(List<Lotto> purchasedLottos);

  /**
   * 당첨 내역을 출력한다.
   *
   * @param winningPortfolio 당첨 내역
   */
  void printWinningStatistics(WinningPortfolio winningPortfolio);

  /**
   * 수익률을 출력한다.
   *
   * @param rateOfReturn 수익률
   */
  void printRateOfReturn(Double rateOfReturn);
}
