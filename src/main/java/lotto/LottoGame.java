package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
  private List<Lotto> purchasedTickets = new ArrayList<>();
  private Lotto winningTicket;

  public void purchaseTickets(int numberOfTickets) {
    for (int i = 0; i < numberOfTickets; i++) {
      purchasedTickets.add(generateRandomLotto());
    }
  }
  


  private Lotto generateRandomLotto() {
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    return null;
  }



}
