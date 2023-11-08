package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
  public static void main(String[] args) {

    // 구매금액 입력, 티켓 개수 출력
    Purchase purchase = new Purchase();
    int numberOfTickets = purchase.purchaseAmount();

    // 발행 티켓 출력
    LottoGame lottoGame = new LottoGame();
    lottoGame.purchaseTickets(numberOfTickets);

    // 당첨 티켓 입력 받기
    LottoNumber lotto = new LottoNumber();
    List<Integer> winningNumbers = lotto.lottoNumber();
    int bonusNumber = lotto.bonusNumber();

    Lotto winningTicket = new Lotto(winningNumbers);
    lottoGame.setWinningTicket(winningTicket);

    int[] results = lottoGame.calculateResults(bonusNumber);

    PrizeMoney Prize = new PrizeMoney();
    Prize.printResults(results);

    int totalPurchaseCost =    numberOfTickets * 1000;
    double totalRevenueRate = Prize.calculateTotalRevenueRate(results,totalPurchaseCost);
    double roundedRevenueRate = Math.round(totalRevenueRate * 100.0) / 100.0;
    System.out.println("총 수익률은 " + roundedRevenueRate + "% 입니다.");
  }

}


