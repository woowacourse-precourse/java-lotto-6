package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class LottoGame {
  private final Integer MONEYUNIT = 1000;
  private final Double THREEAWARD = 5000.0;
  private final Double FOURAWARD = 50000.0;
  private final Double FIVEAWARD = 1500000.0;
  private final Double FIVEANDBONUSAWARD = 30000000.0;
  private final Double SIXAWARD = 2000000000.0;
  private final Integer THREEMATCH = 3;
  private final Integer FOURMATCH = 4;
  private final Integer FIVEMATCH = 5;
  private final Integer FIVEMATCHANDBONUS = 7;
  private final Integer SIXMATCH = 6;

  private ArrayList<Lotto> reciept = new ArrayList<>();
  private LottoMachine machine = new LottoMachine();
  private Teller teller = new Teller();
  private HashMap<Integer, Integer> wins = new HashMap<>();
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
    calculateWin();
    teller.showResult(wins);
    Double awardPercent = calculateWinPercentage();
    teller.showTotalWin(awardPercent);
  }

  public void calculateWin() {
    for (Lotto lotto : reciept) {
      Integer matchCount = lotto.matchedLottoCount(lottoNumbers);
      if (lotto.didMatchBonus(bonusNumber) && matchCount == 5) {
        updateWins(7);
        return;
      }
      updateWins(matchCount);
    }
  }

  public void updateWins(Integer matchCount) {
    if(wins.containsKey(matchCount)) {
      Integer newValue = wins.get(matchCount) + 1;
      wins.put(matchCount, newValue);
      return;
    }
    wins.put(matchCount, 1);
  }

  public Double calculateWinPercentage() {
    Double totalWin = teller.formatWins(wins.get(THREEMATCH)) * THREEAWARD;
    totalWin += teller.formatWins(wins.get(FOURMATCH)) * FOURAWARD;
    totalWin += teller.formatWins(wins.get(FIVEMATCH)) * FIVEAWARD;
    totalWin += teller.formatWins(wins.get(FIVEMATCHANDBONUS)) * FIVEANDBONUSAWARD;
    totalWin += teller.formatWins(wins.get(SIXMATCH)) * SIXAWARD;
    return (totalWin / moneyAmount) * 100;
  }
}
