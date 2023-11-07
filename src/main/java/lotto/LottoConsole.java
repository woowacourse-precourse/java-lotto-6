package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

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

  private void getSpendMoney() {
    try {
      System.out.println("구입금액을 입력해 주세요.");
      try {
        spendMoney = Integer.parseInt(readLine());
        if (spendMoney % 1000 != 0) {
          throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        if (spendMoney < 0 ) {
          throw new IllegalArgumentException("[ERROR] 구입 금액은 0 이상의 정수이어야 합니다.");
        }
        paidLottoCount = spendMoney / 1000;
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("[ERROR] 구입금액은 정수인 숫자여야 합니다.");
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      getSpendMoney();
    }
  }
}
