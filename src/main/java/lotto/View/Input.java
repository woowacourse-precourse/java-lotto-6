package lotto.View;

import camp.nextstep.edu.missionutils.Console;
public class Input {

  public static int getPurchaseAmount() {
    System.out.println("입금액을 입력해 주세요:");
    return Integer.parseInt(Console.readLine());
  }

  public static String getWinningNumbers() {
    System.out.println("당첨 번호를 입력해 주세요:");
    return Console.readLine();
  }

  public static int getBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요:");
    return Integer.parseInt(Console.readLine());
  }
}