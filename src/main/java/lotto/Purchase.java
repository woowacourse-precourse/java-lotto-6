package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
  public int purchaseAmount() {
    System.out.println("로또 구입 금액을 입력하세요.");
    int purchaseAmount = Integer.parseInt(Console.readLine());
    int numberOfTickets = purchaseAmount / 1000;
    return numberOfTickets;
  }

  private void exception_divide(int p) {
      if(p % 1000 != 0) {
        throw new IllegalArgumentException("1000으로 나눠지지 않습니다.");
      }
    }
}
