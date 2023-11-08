package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Payment;
import lotto.model.WinningNumber;
import lotto.service.CalcRate;
import lotto.service.CompareNumber;
import lotto.service.CreateLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
  private final InputView inputView = new InputView();
  private final OutputView outputView = new OutputView();
  private final Payment payment = new Payment();
  private final CreateLotto createLotto = new CreateLotto();
  private final CalcRate calcRate = new CalcRate();

  public void run() {
    int money = getPayment();
    List<Lotto> lottos = getLottoList(money);
    List<Integer> winning = getWinningList();
    int bonus = getBonusNum(winning);
    int[] result = compareNumbers(lottos, winning, bonus);
    printResults(result, money);
  }

  private int getPayment() {
    int money;
    while (true) {
      try {
        money = inputView.getPaymentInput();
        return money;
      } catch (IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
      }
    }
  }

  private List<Lotto> getLottoList(int money) {
    int ticket = payment.ticketNumber(money);
    outputView.printTicketNumber(ticket);
    List<Lotto> lottos = createLotto.createLottos(ticket);
    outputView.printLottoList(ticket, lottos);
    return lottos;
  }

  private List<Integer> getWinningList() {
    List<Integer> winning;
    while (true) {
      try {
        winning = inputView.getWinningInput();
        WinningNumber winningNumber = new WinningNumber(winning);
        return winning;
      } catch (IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
      }
    }
  }

  private int getBonusNum(List<Integer> winning) {
    int bonus;
    while (true) {
      try {
        bonus = inputView.getBonusInput(winning);
        return bonus;
      } catch (IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
      }
    }
  }

  private int[] compareNumbers(List<Lotto> lottos, List<Integer> winning, int bonus) {
    return CompareNumber.compareNumber(lottos, winning, bonus);
  }

  private void printResults(int[] result, int money) {
    OutputView.printPrizeResult(result);
    double rate = calcRate.calcRate(result, money);
    OutputView.printRate(rate);
  }
}
