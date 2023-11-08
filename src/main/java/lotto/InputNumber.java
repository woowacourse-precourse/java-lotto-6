package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputNumber {

  private static List<Integer> prizeNumberList;

  public static List<Integer> createPrizeNumber() {
    System.out.println("당첨 번호를 입력해 주세요.");
    String inputValue = Console.readLine();
    System.out.println(inputValue);
    convertInteger(inputValue);
    prizeNumberList.add(createBonusNumber());
    return prizeNumberList;
  }

  public static int createBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
    String inputValue = Console.readLine();
    System.out.println(inputValue);
    return validInteger(inputValue);
  }

  public static void convertInteger(String inputNumber) {
    for (String number : inputNumber.split(",")) {
      prizeNumberList.add(validInteger(number));
    }
  }

  public static int validInteger(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
    }
  }
}
