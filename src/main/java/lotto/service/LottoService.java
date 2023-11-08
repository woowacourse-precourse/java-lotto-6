package lotto.service;

import java.util.List;
import lotto.model.MyLotto;
import lotto.model.Lotto;

public class LottoService {

  private final NumberGenerator numberGenerator;

  public LottoService(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  private List<Integer> getLottery() {
    return numberGenerator.generate();
  }

  public MyLotto lotteryIssuance(String amount) {

    MyLotto myLotto = MyLotto.purchase(amount);

    for (int i = 0; i < myLotto.getLottoTickets(); i++)
      myLotto.addLotto(new Lotto(getLottery()));

    return myLotto;
  }

  public WinLotto setWinningLottery(String winLottoValue, String bonusNumValue) {

    return WinLotto.setWinLotto(winLottoValue, bonusNumValue);
  }
}
