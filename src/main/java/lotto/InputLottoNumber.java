package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class InputLottoNumber {
  public static List<Integer> inputNumber() {
    System.out.println();
    System.out.println("당첨 번호를 입력해 주세요.");
    String input = readLine();
    return validateInputNumber(input);
  }

  public int bonusNumber() {
    System.out.println();
    System.out.println("보너스 번호를 입력해 주세요.");
    int bonus = parseInt(readLine());
    return bonus;
  }

  private static List<Integer> validateInputNumber(String input) {
    List<Integer> numbers = new ArrayList<>();
    String[] numberTokens = input.split(",");

    for (String token : numberTokens) {
      try {
        int number = parseInt(token);
        if (number < 1 || number > 45) {
          throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
        numbers.add(number);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("유효하지 않은 번호: " + token);
      }
    }

    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }

    return numbers;
  }
}

