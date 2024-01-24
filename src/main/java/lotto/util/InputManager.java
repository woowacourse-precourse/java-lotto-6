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
        int inputAmount = Integer.parseInt(Console.readLine().trim());
        return new PurchaseAmount(inputAmount);
      } catch (NumberFormatException e) {
        System.out.println(ErrorMessage.NOT_A_NUMBER.getMessage());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public UserInputNumbers receiveLottoNumber() {
    while (true) {
      try {
        List<Integer> receivedLottoNumbers = receiveLottoNumbers();
        int bonusNumber = receiveBonusNumber();
        return new UserInputNumbers(receivedLottoNumbers, bonusNumber);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private List<Integer> receiveLottoNumbers() {
    try {
      System.out.println("\n당첨 번호를 입력해 주세요.");
      String inputNumbers = Console.readLine();
      String[] separatedNumbers = inputNumbers.split(",");
      return Arrays.stream(separatedNumbers)
          .map(String::trim)
          .map(Integer::parseInt)
          .toList();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
    }
  }

  private int receiveBonusNumber() {
    try {
      System.out.println("\n보너스 번호를 입력해 주세요.");
      return Integer.parseInt(Console.readLine().trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessage.NOT_A_SINGLE_NUMBER.getMessage());
    }
  }
}
