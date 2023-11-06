package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchaseAmountValidator {
  public int validatePurchaseAmount() {
    while (true) {
      try {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % 1000 != 0) {
          throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
      } catch (IllegalArgumentException e) {
        System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
      }
    }
  }
}
