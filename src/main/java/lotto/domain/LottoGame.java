package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
  private List<Lotto> reciept = new ArrayList<>();
  private LottoMachine machine = new LottoMachine();
  private Teller teller = new Teller();
  private Bank bank = new Bank();

  private Integer lottoAmount = 0;
  private Integer moneyAmount = 0;

  public void start() {
    moneyAmount = teller.getMoneyAmount();
  }
}
