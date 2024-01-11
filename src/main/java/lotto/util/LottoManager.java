package lotto.util;

import static lotto.numbers.Lotto.MAX_LOTTO_NUMBER;
import static lotto.numbers.Lotto.MIN_LOTTO_NUMBER;
import static lotto.numbers.Lotto.SIZE_OF_LOTTO;
import static lotto.util.Money.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.numbers.Lotto;
import lotto.numbers.UserInputNumbers;

public class LottoManager {

  public void runLotto() {
    Money money = receivePurchaseAmount();
    List<Lotto> lottos = generateLottos(money.getAmount());
    printGeneratedLottoNumbers(lottos);
    UserInputNumbers receivedLotto = receiveLottoNumber();
    Map<WinningCheck, Integer> result = calculateWinningResult(lottos, receivedLotto);
    printWinningResult(result);
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
    System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

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

  private void printGeneratedLottoNumbers(List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      List<Integer> lottoNumbers = lotto.getLottoNumbers();
      Collections.sort(lottoNumbers);
      System.out.println(lottoNumbers);
    }
  }

  private UserInputNumbers receiveLottoNumber() {
    while (true) {
      System.out.println("\n당첨 번호를 입력해 주세요.");
      String inputNumbers = Console.readLine();
      try {
        String[] numbersArray = inputNumbers.split(",");
        List<Integer> receivedLottoNumbers = new ArrayList<>();
        Arrays.stream(numbersArray)
            .forEach(number -> receivedLottoNumbers.add(Integer.parseInt(number.trim()))); // 공백 제거
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());

        return new UserInputNumbers(receivedLottoNumbers, List.of(bonusNumber));
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private Map<WinningCheck, Integer> calculateWinningResult(List<Lotto> lottos
      , UserInputNumbers receivedLotto) {
    Map<WinningCheck, Integer> result = new HashMap<>(); // WinningCheck 객체와 정수를 키와 값으로 Map에 저장
    for (Lotto lotto : lottos) {
      int matchCount = lotto.getMatchCount(receivedLotto);
      boolean bonusMatch = lotto.isBonusMatch(receivedLotto);

      WinningCheck prize = WinningCheck.getPrize(matchCount, bonusMatch);
      result.put(prize // prize 키와 해당하는 값을 Map에 넣는다. 이미 있다면 덮어쓴다
          , result.getOrDefault(prize, 0) + 1);
       /*키(prize)에 해당하는 값을 가져온다. 없다면 default(0)을 반환
       -> 해당하는 현재의 당첨 수를 가져오고 그 수에 1을 더해서 새로운 당첨 수를 계산함*/
    }
    return result;
  }

  private void printWinningResult(Map<WinningCheck, Integer> result) {
    System.out.println("\n당첨 통계\n---");
    for (WinningCheck prize : WinningCheck.values()) {
      if (prize == WinningCheck.LOSE) {
        continue;
      }
      String bonus = prize.hasBonus() ? ", 보너스 볼 일치" : "";
      System.out.println(
          prize.getMatchingCount() + "개 일치" + bonus + " (" + prize.getPrizeAmount() + "원) - "
              + result.getOrDefault(prize, 0) + "개");
    }
  }
}