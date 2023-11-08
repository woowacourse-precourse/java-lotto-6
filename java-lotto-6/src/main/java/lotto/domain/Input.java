package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Input {
  public static final int LOTTO_PRICE = 1000;

  public static int buyLotto() {
    int LottoPurchaseAmount = 1;
    while (LottoPurchaseAmount % LOTTO_PRICE != 0) {
      try {
        System.out.println("구입금액을 입력해 주세요.");
        LottoPurchaseAmount = Integer.parseInt(readLine());
        if (LottoPurchaseAmount % LOTTO_PRICE != 0) {
          throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 로또 구입 금액은 숫자로 입력해야 합니다.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    return LottoPurchaseAmount;
  }

  public static List<Integer> enterWinningNumber() {
    List<Integer> winningNumbers = new ArrayList<>();
    boolean validInput = false;
    while (!validInput) {
      try {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = new ArrayList<>();
        winningNumbers = List.of(readLine().split(",")).stream().map(Integer::parseInt).toList();
        validInput = isValidLottoNumbers(winningNumbers);
        if (!validInput) {
          throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 로또당첨번호는 숫자로 입력해야 합니다.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }

    }
    return winningNumbers;
  }

  public static int enterBonusNumber() {

    int bonusNumber = 0;
    try {
      System.out.println("보너스 번호를 입력해 주세요.");
      bonusNumber = Integer.parseInt(readLine());
      if (bonusNumber < 1 || bonusNumber > 45) {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
      }
    } catch (NumberFormatException e) {
      System.out.println("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    return bonusNumber;

  }

  public static boolean isValidLottoNumbers(List<Integer> numbers) {
    for (Integer num : numbers) {
      if (num < 1 || num > 45) {
        return false;
      }
    }
    return true;
  }
}
