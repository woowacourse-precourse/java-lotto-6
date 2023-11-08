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
    double totalRevenueRate = Prize.calculateTotalRevenueRate(results, totalPurchaseCost);
    double roundedRevenueRate = Math.round(totalRevenueRate * 100.0) / 100.0;
    DecimalFormat df = new DecimalFormat("#,###,###,###,###.##%");
    String formattedNumber = df.format(roundedRevenueRate / 100);  // 소수점 둘째 자리에서 반올림
    System.out.println("총 수익률은 " + formattedNumber+"입니다.");

  }

}


