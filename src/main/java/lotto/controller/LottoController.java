package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Bonus;
import lotto.model.LotteryMachine;
import lotto.model.LotteryResult;
import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.PersonLotto;
import lotto.model.PurchaseMoney;
import lotto.model.WinningLotto;
import lotto.model.WinningMoney;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputView;

public class LottoController {

  private final InputView inputView;

  public LottoController(InputView inputView) {
    this.inputView = inputView;
  }

  public void start() {
    PurchaseMoney purchaseMoney = readPurchaseMoney();
    RandomNumbersGenerator generate = new RandomNumbersGenerator();
    PersonLotto personLotto = new PersonLotto(generate, purchaseMoney);

    WinningLotto winningLotto = readWinningNumbers();

    Bonus bonus = readBonusNumber(winningLotto);

    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);
    Map<WinningMoney, Integer> result = lotteryMachine.drawingLotto(bonus);

    LotteryResult lotteryResult = new LotteryResult(result);
    lotteryResult.getProfitPercentage(purchaseMoney);
  }

  private PurchaseMoney readPurchaseMoney() {
    PurchaseMoney readValue;
    while (true) {
      try {
        int money = inputView.inputPurchaseMoneyOfLotto();
        readValue = new PurchaseMoney(money);
        break;
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return readValue;
  }

  private WinningLotto readWinningNumbers() {
    WinningLotto readValue;
    while (true) {
      try {
        List<Integer> readNumbers = inputView.inputWinningNumbers();
        readValue = new WinningLotto(new Lotto(readNumbers));
        break;
      } catch (Exception ex) {
      }
    }
    return readValue;
  }

  private Bonus readBonusNumber(WinningLotto winningLotto) {
    Bonus readValue;
    while (true) {
      try {
        int readBonus = inputView.inputBonusNumber();
        readValue = new Bonus(new Number(readBonus), winningLotto);
        break;
      } catch (Exception ex) {
        readBonusNumber(winningLotto);
      }
    }
    return readValue;
  }
}
