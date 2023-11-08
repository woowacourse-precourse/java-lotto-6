package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
  private ArrayList<Lotto> reciept = new ArrayList<>();
  private LottoMachine machine = new LottoMachine();
  private Teller teller = new Teller();
  private Bank bank = new Bank();

  private final Integer MONEYUNIT = 1000;
  
  private List<Integer> lottoNumbers;
  private Integer lottoAmount = 0;
  private Integer moneyAmount = 0;
  private Integer bonusNumber = 0;

  public void start() {
    moneyAmount = teller.getMoneyAmount();
    lottoAmount = moneyAmount / MONEYUNIT;
    teller.showMoneyAmount(lottoAmount);
    machine.generateLottoNumbers(reciept, lottoAmount);
    teller.showLottoNumbers(reciept);
    lottoNumbers = teller.getLottoNumbers();
    bonusNumber = teller.getBonusNumber(lottoNumbers);
  }
}
