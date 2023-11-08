package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

  public static int getPurchaseAmount() {
    System.out.println("입금액을 입력해 주세요:");
    // Todo : DTO 로 생성해서 만들어도 괜찮을듯. + magic number 제거
    int ticket = Integer.parseInt(Console.readLine()) / 1000;
    return ticket;
  }

  public static List<Integer> getWinningNumbers() {
    System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분하여 입력):");
    String input = Console.readLine();

    // 쉼표를 기준으로 입력된 값을 분리하여 List에 추가
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