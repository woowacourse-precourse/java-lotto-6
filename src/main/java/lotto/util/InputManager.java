package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.PurchaseAmount;
import lotto.domain.UserInputNumbers;

public class InputManager {

  public PurchaseAmount receivePurchaseAmount() {
    while (true) {
      try {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return new PurchaseAmount(input);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }


  public UserInputNumbers receiveLottoNumber() {
    while (true) {
      System.out.println("\n당첨 번호를 입력해 주세요.");
      String inputNumbers = Console.readLine();
      try {
        String[] separatedNumbers = inputNumbers.split(",");
        List<Integer> receivedLottoNumbers = Arrays.stream(separatedNumbers)
            .map(String::trim)
            .map(Integer::parseInt)
            .toList();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());

        return new UserInputNumbers(receivedLottoNumbers, bonusNumber);
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 보너스 번호는 1개여야 합니다."); // 하나가 아니라면 String으로 인식
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
