package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {
  Map<LottoPrizes, Integer> winningTickets = new LinkedHashMap<>();

  public LottoResults() {
    this.winningTickets.put(LottoPrizes.FifthPlace, 0);
    this.winningTickets.put(LottoPrizes.FourthPlace, 0);
    this.winningTickets.put(LottoPrizes.ThirdPlace, 0);
    this.winningTickets.put(LottoPrizes.SecondPlace, 0);
    this.winningTickets.put(LottoPrizes.FirstPlace, 0);
  }
}
