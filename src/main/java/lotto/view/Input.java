package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

  public static int getPurchaseAmount() {
    System.out.println("입금액을 입력해 주세요:");
    int purchaseAmount = readAndValidatePurchaseAmount();
    return purchaseAmount;
  }

  private static int readAndValidatePurchaseAmount() {
    while (true) {
      try {
        int amount = Integer.parseInt(Console.readLine()) / 1000;
        validatePurchaseAmount(amount);
        return amount;
      } catch (IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage() + " 다시 입력해주세요.");
      } catch (IllegalStateException e) {
        System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
      }
    }
  }

  private static void validatePurchaseAmount(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("입금액은 1,000원 이상이어야 합니다.");
    }
  }

  public static List<Integer> getWinningNumbers() {
    System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분하여 입력):");
    String input = Console.readLine();
    String[] numberStrings = input.split(",");
    List<Integer> numbers = new ArrayList<>();
    for (String numberString : numberStrings) {
      // 입력된 문자열을 정수형으로 변환하여 리스트에 추가
      numbers.add(Integer.parseInt(numberString.trim()));
    }

    return numbers;
  }

  public static int getBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요:");
    return Integer.parseInt(Console.readLine());
  }
}