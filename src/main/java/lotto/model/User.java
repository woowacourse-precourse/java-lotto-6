package lotto.model;

import java.util.List;

public class User {

  private Lotto lotto;
  private List<Lotto> lottoTickets;
  private int numberOfLottery;

  public void buyLotto(String amount) {
    // 로또 매수 저장
    this.numberOfLottery = LotteryCalculator.divideByLottoPrice(amount);
  }

  public void saveLotto(List<Lotto> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }

  public List<Lotto> getLottoTickets() {
    return lottoTickets;
  }

  public int getNumberOfLottery() {
    return numberOfLottery;
  }
}
