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
import java.util.List;
import lotto.numbers.Lotto;
import lotto.numbers.UserInputNumbers;

public class LottoManager {

  public void runLotto() {
    Money money = receivePurchaseAmount();
    List<Lotto> lottos = generateLottos(money.getAmount());
    printLottoNumbers(lottos);
    UserInputNumbers receivedLotto = receiveLottoNumber();
    printLotto(receivedLotto);
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

  private void printLottoNumbers(List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      List<Integer> lottoNumbers = lotto.getLottoNumbers();
      System.out.println(lottoNumbers.toString());
    }
  }

  private UserInputNumbers receiveLottoNumber() {
    while (true) {
      System.out.println("\n당첨 번호를 입력해 주세요.");
      String inputNumbers = Console.readLine();
      System.out.println("\n보너스 번호를 입력해 주세요.");
      String inputBonusNumber = Console.readLine();
      try {
        String[] numbersArray = inputNumbers.split(",");
        List<Integer> receivedLottoNumbers = new ArrayList<>();
        Arrays.stream(numbersArray)
            .forEach(number -> receivedLottoNumbers.add(Integer.parseInt(number.trim()))); // 공백 제거
        List<Integer> bonusNumber = Collections.singletonList(
            Integer.parseInt(inputBonusNumber.trim()));

        return new UserInputNumbers(receivedLottoNumbers, bonusNumber);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private void printLotto(UserInputNumbers receivedLotto) { // 테스트 코드 짜는 법 까먹었어요ㅜㅜ
    List<Integer> inputLotto = receivedLotto.getReceivedLottoNumbers();
    List<Integer> inputBonus = receivedLotto.getBonusNumber();
    System.out.print(inputLotto);
    System.out.print(inputBonus);
  }
}