package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoManager {

  public void runLotto() {
    PurchaseAmount purchaseAmount = receivePurchaseAmount();
    printSortedLottoNumbers(purchaseAmount.getAmount());

  }

  private PurchaseAmount receivePurchaseAmount() {
    PurchaseAmount purchaseAmount;
    while (true) {
      try {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int inputAmount = Integer.parseInt(input);
        purchaseAmount = new PurchaseAmount(inputAmount);
        break;
      } catch (IllegalArgumentException e) {
        System.out.println("[ERROR] 1000 단위의 금액을 입력하세요.");
      }
    }
    return purchaseAmount;
  }

  private static void printSortedLottoNumbers(int purchaseAmount) {
    int purchaseLotto = purchaseAmount / 1000;
    System.out.println(purchaseLotto + "개를 구매했습니다.");

    List<List<Integer>> allLottoNumbers = generateLottoNumbers(purchaseLotto);

    for (List<Integer> LottoNumbers : allLottoNumbers) {
      System.out.println(LottoNumbers);
    }
  }

  private static List<Integer> generateLottoNumbers(int purchaseLotto) {
    List<List<Integer>> allLottoNumbers = new ArrayList<>();

    for (int ticketIndex = 0; ticketIndex < purchaseLotto; ticketIndex++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      allLottoNumbers.add(numbers);
    }

    return allLottoNumbers;
  }
}