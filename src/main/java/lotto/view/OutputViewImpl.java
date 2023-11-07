package lotto.view;

import lotto.model.MyLotto;

public class OutputViewImpl implements OutputView {
  private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

  @Override
  public void printEmptyLine() {
    System.out.println();
  }

  @Override
  public void printPurchasedMessage(MyLotto myLotto) {
    System.out.println(myLotto + PURCHASE_MESSAGE);
  }

  @Override
  public void printPurchasedMyLottoList() {
    System.out.println(MyLotto.printAllMyLotto());
  }
}
