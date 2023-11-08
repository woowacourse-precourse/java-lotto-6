package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
  private List<Lotto> purchasedTickets = new ArrayList<>();
  private Lotto winningTicket;

  public void purchaseTickets(int numberOfTickets) {

    for (int i = 0; i < numberOfTickets; i++) {
      Lotto purchasedTicket = generateRandomLotto();
      purchasedTickets.add(purchasedTicket);
      System.out.println(purchasedTicket.getNumbers());
    }
  }


  public void setWinningTicket(Lotto winningTicket) {
    this.winningTicket = winningTicket;
  }

  // 당첨된 숫자 3개 이상인 티켓 처리
  public int[] calculateResults(int bonusNumber) {
    int[] results = new int[5];

    for (Lotto ticket : purchasedTickets) {
      calculateTicketResults(ticket, results, bonusNumber);
    }

    return results;
  }

  private void calculateTicketResults(Lotto ticket, int[] results, int bonusNumber) {
    int matchingNumbers = ticket.countMatchingNumbers(winningTicket);
    if (matchingNumbers >= 3) {
      results[matchingNumbers - 3]++;
    }

    if (results[2] > 0) {
      int bonusMatching = ticket.countMatchingNumbers(bonusNumber);
      if (bonusMatching > 0) {
        results[4]++;
        results[2]--;
      }
    }
  }

  private Lotto generateRandomLotto() {
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    List<Integer> sortedNumbers = new ArrayList<>(numbers); // 복제
    Collections.sort(sortedNumbers);
    return new Lotto(sortedNumbers);
  }



}
