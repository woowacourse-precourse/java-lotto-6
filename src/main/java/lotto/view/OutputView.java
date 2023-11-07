package lotto.view;

import lotto.model.MyLotto;

public interface OutputView {

  void printEmptyLine();

  void printPurchasedMessage(MyLotto myLotto);

  void printPurchasedMyLottoList();
}
