package lotto.view;

import lotto.dto.Result;
import lotto.model.MyLotto;

public class OutputViewImpl implements OutputView {
  private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
  private static final String LOTTO_WINNING_STATS = "당첨 통계";
  private static final String SEPARATOR = "---";


  @Override
  public void printEmptyLine() {
    System.out.println();
  }

  @Override
  public void printErrorMessage(IllegalArgumentException exception) {
    System.out.println(exception.getMessage());
  }

  @Override
  public void printPurchasedMessage(MyLotto myLotto) {
    System.out.println(myLotto.getLottoTickets() + PURCHASE_MESSAGE);
  }

  @Override
  public void printPurchasedMyLottoList() {
    System.out.println(MyLotto.getAllMyLottoAsString());
  }

  @Override
  public void printWinningStatistics() {
    System.out.println(LOTTO_WINNING_STATS);
  }

  @Override
  public void printSeparator() {
    System.out.println(SEPARATOR);
  }

  @Override
  public void printWinningStatisticsSummary(Result result) {
    System.out.println(result);
  }
}
