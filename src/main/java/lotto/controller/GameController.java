package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Payment;
import lotto.model.WinningNumber;
import lotto.service.CalcRate;
import lotto.service.CompareNumber;
import lotto.service.CreateLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
  InputView inputView = new InputView();
  OutputView outputView = new OutputView();
  Payment payment = new Payment();
  CreateLotto createLotto = new CreateLotto();
  CalcRate calcRate = new CalcRate();

  public void playGame(){
    int money = getPayment();
    int ticket = getTicket(money);
    List<Lotto> lottos = getLottoList(ticket);
    List<Integer> winning = getWinningList();
    int bonus = getBonusNum(winning);
    int[] result = compareNumbers(lottos, winning, bonus);
    printResults(result, money);
  }

  private int getPayment(){
    int money;
    while(true){
      try {
        money = inputView.getPaymentInput();
        payment.ticketNumber(money);
        return money;
      }catch (IllegalArgumentException e){
        System.out.println("[ERROR] " + e.getMessage());
      }
    }
  }

  private int getTicket(int money){
    int ticket = payment.ticketNumber(money);
    outputView.printTicketNumber(ticket);
    return ticket;
  }

  private List<Lotto> getLottoList(int ticket){
    List<Lotto> lottos = createLotto.createLottos(ticket);
    outputView.printLottoList(ticket, lottos);
    return lottos;
  }

  private List<Integer> getWinningList(){
    List<Integer> winning;
    while (true){
      try {
        winning = inputView.getWinningInput();
        WinningNumber winningNumber = new WinningNumber(winning);
        System.out.println(winning);
        return winning;
      }catch (IllegalArgumentException e){
        System.out.println("[ERROR] " + e.getMessage());
      }
    }
  }

  private int getBonusNum(List<Integer> winning){
    int bonus;
    while (true){
      try {
        bonus = inputView.getBonusInput(winning);
        BonusNumber bonusNumber = new BonusNumber(bonus);
        System.out.println(bonus);
        return bonus;
      } catch (IllegalArgumentException e){
        System.out.println("[ERROR] " + e.getMessage());
      }
    }
  }

  private int[] compareNumbers(List<Lotto> lottos, List<Integer> winning, int bonus){
    return CompareNumber.compareNumber(lottos, winning, bonus);
  }

  private void printResults(int[] result, int money){
    OutputView.printPrizeResult(result);
    double rate = calcRate.calcRate(result, money);
    OutputView.printRate(rate);
  }
}
