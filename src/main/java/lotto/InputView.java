package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
  //  로또 구매 금액을 사용자로부터 입력받는 메서드.
  public int requestPurchaseAmount() {
    while (true) {
      try {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % 1000 != 0) {
          throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        return amount;
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자만 입력 가능합니다.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }
  
  //  당첨 번호를 사용자로부터 입력받는 메서드.
  public List<Integer> requestWinningNumbers() {
    while (true) {
      try {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        
        if (numbers.size() != 6 || numbers.stream().anyMatch(num -> num < 1 || num > 45)
            || numbers.stream().distinct().count() != 6) {
          throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 중복되지 않는 숫자 6개여야 합니다.");
        }
        return numbers;
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자만 입력 가능합니다.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }
  
  //  보너스 번호를 사용자로부터 입력받는 메서드.
  public int requestBonusBall() {
    while (true) {
      try {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = Integer.parseInt(Console.readLine());
        if (bonusBall < 1 || bonusBall > 45) {
          throw new IllegalArgumentException("[ERROR] 보너스 볼은 1~45 사이의 숫자여야 합니다.");
        }
        return bonusBall;
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자만 입력 가능합니다.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}