package lotto.util;

import static lotto.numbers.Lotto.MAX_LOTTO_NUMBER;
import static lotto.numbers.Lotto.MIN_LOTTO_NUMBER;
import static lotto.numbers.Lotto.SIZE_OF_LOTTO;
import static lotto.util.Money.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.numbers.Lotto;

public class LottoManager {

  public void runLotto() {
    Money money = receivePurchaseAmount();
    List<Lotto> lottos = generateLottos(money.getAmount());
    printLottoNumbers(lottos);
  }

  private Money receivePurchaseAmount() {
    Money money;
    while (true) {
      try {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int inputAmount = Integer.parseInt(input);
        money = new Money(inputAmount);
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    return money;
  }

  private List<Lotto> generateLottos(int money) {
    int numberOfLotto = money / LOTTO_PRICE;
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < numberOfLotto; i++) {
      List<Integer> lottoNumbers =
          Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, SIZE_OF_LOTTO);

      try {
        Lotto lotto = new Lotto(lottoNumbers);
        lottos.add(lotto);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        i--;
      }
    }

    return lottos;
  }

  public void printLottoNumbers(List<Lotto> lottos) {
    List<String> lottoNumbers = new ArrayList<>();
    for (Lotto lotto : lottos) {
      lottoNumbers.add(String.join(", ", lotto.getLottoNumbers().toString()));
    }
    Collections.sort(lottoNumbers);
    for (int i = 0; i < lottoNumbers.size(); i++) {
      System.out.println(lottoNumbers.get(i));
    }
  }
}