package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
  public static void main(String[] args) {

    Purchase purchase = new Purchase();
    // purchase.purchaseAmount();
    int numberOfTickets = purchase.purchaseAmount();
    System.out.println(numberOfTickets);

    LottoGame lottoGame = new LottoGame();
    lottoGame.purchaseTickets(numberOfTickets);

    LottoNumber lotto = new LottoNumber();
    lotto.lottoNumber();

  }

}
