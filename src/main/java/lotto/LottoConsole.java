package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoConsole {
  private Integer spendMoney;
  private Integer paidLottoCount;
  private List<Lotto> paidLottos;
  private Lotto winningLotto;
  private Integer bonusNumber;
  private List<Integer> scores;
  private Long earnedMoney;

  public LottoConsole() {
    paidLottos = new ArrayList<>();
    scores = Arrays.asList(0,0,0,0,0,0);
    earnedMoney = 0L;
  }
}
