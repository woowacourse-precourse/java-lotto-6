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

  private void buy() {
    System.out.println("\n" + paidLottoCount + "개를 구매했습니다.");
    for(int i=0; i<paidLottoCount; i++) {
      paidLottos.add(new Lotto(Lotto.generateLotto()));
      System.out.println(paidLottos.get(i));
    }
    System.out.println();
  }

  private void getWinningLotto() {
    try {
      System.out.println("당첨 번호를 입력해 주세요.");
      List<Integer> numbers = new ArrayList<Integer>();
      String inputWinningLotto = readLine();
      try {
        numbers = Arrays.stream(inputWinningLotto.split(","))
            .map(number -> Integer.parseInt(number))
            .toList();
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("[ERROR] 6개의 당첨 로또 번호를 입력 받습니다. 번호는 정수형태이며 쉼표(,)를 기준으로 구분해야 합니다.");
      }
      winningLotto = new Lotto(numbers);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      getWinningLotto();
    }
  }
}
