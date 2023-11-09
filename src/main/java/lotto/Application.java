package lotto;

import java.text.DecimalFormat;
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
    int bonusNumber = lotto.bonusNumber(winningNumbers);

    Lotto winningTicket = new Lotto(winningNumbers);
    lottoGame.setWinningTicket(winningTicket);
    System.out.println("당첨 통계");
    System.out.println("---");

    int[] results = lottoGame.calculateResults(bonusNumber);

    PrizeMoney Prize = new PrizeMoney();
    Prize.printResults(results);
    
    int totalPurchaseCost =    numberOfTickets * 1000;
    double totalRevenueRate = Prize.calculateTotalRevenueRate(results, totalPurchaseCost) / 100.0;
    String formattedRevenueRate = Prize.formatRevenueRate(totalRevenueRate);
    System.out.println("총 수익률은 " + formattedRevenueRate + "입니다.");

  }

}


