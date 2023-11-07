package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
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
import lotto.util.NumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  private final InputView inputView;
  private final OutputView outputView;
  private final NumbersGenerator generate;

  public LottoController(InputView inputView, OutputView outputView,
      NumbersGenerator numbersGenerator) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.generate = numbersGenerator;
  }

  public void start() {
    PurchaseMoney purchaseMoney = initPurchaseMoney(inputView.inputPurchaseMoneyOfLotto());
    PersonLotto personLotto = initPersonLotto(generate, purchaseMoney);
    WinningLotto winningLotto = initWinningNumbers();
    Bonus bonus = initBonusNumber(winningLotto);
    LotteryMachine lotteryMachine = initLotteryMachine(personLotto, winningLotto);

    result(lotteryMachine, bonus, purchaseMoney);
  }

  private void result(LotteryMachine lotteryMachine, Bonus bonus, PurchaseMoney purchaseMoney) {
    Map<WinningMoney, Integer> result = lotteryMachine.drawingLotto(bonus);
    LotteryResult lotteryResult = new LotteryResult(result);
    outputView.outputResult(lotteryResult, purchaseMoney);
  }

  private LotteryMachine initLotteryMachine(PersonLotto personLotto, WinningLotto winningLotto) {
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);
    return lotteryMachine;
  }

  private PersonLotto initPersonLotto(NumbersGenerator generate, PurchaseMoney purchaseMoney) {
    PersonLotto personLotto = new PersonLotto(generate, purchaseMoney);
    outputView.outputPurchase(purchaseMoney, personLotto);
    return personLotto;
  }

  private PurchaseMoney initPurchaseMoney(int inputMoney) {
    PurchaseMoney readValue;
    while (true) {
      try {
        readValue = new PurchaseMoney(inputMoney);
        break;
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return readValue;
  }

  private WinningLotto initWinningNumbers() {
    WinningLotto readValue;
    while (true) {
      try {
        List<Integer> readNumbers = inputView.inputWinningNumbers();
        readValue = new WinningLotto(new Lotto(readNumbers));
        break;
      } catch (Exception ex) {
        ex.printStackTrace();
        Console.close();
      }
    }
    return readValue;
  }

  private Bonus initBonusNumber(WinningLotto winningLotto) {
    System.out.println();
    Bonus readValue;
    while (true) {
      try {
        int readBonus = inputView.inputBonusNumber();
        readValue = new Bonus(new Number(readBonus), winningLotto);
        break;
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return readValue;
  }
}
