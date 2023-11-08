package lotto;

import static lotto.constants.COST;

import camp.nextstep.edu.missionutils.Console;

public class InputPrice {
  
  public static int createPriceNumber() {
    System.out.println("구입금액을 입력해 주세요.");
    String inputValue = Console.readLine();
    System.out.println(inputValue);

    int price = Integer.parseInt(inputValue);
    validatePrice(price);
    return price;
  }

  private static void validatePrice(int price) {
    if (price % COST != 0) {
      throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력할 수 있습니다.");
    }
    if (price <= 0) {
      throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 이상 입력할 수 있습니다.");
    }
  }
}
