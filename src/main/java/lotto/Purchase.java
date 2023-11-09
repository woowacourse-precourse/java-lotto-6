package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
  public int purchaseAmount() {
    System.out.println("로또 구입 금액을 입력하세요.");
    int purchaseAmount = readPurchaseAmount();
    int numberOfTickets = calculateNumberOfTickets(purchaseAmount);
    System.out.println(numberOfTickets + "개를 구매했습니다.");
    return numberOfTickets;
  }

  private int readPurchaseAmount() {
    while (true) {
      try {
        return Integer.parseInt(Console.readLine());
      } catch (NumberFormatException e) {
        System.out.println("[ERROR] 숫자가 아닌 입력입니다.");
      }
    }
  }

  private int calculateNumberOfTickets(int purchaseAmount) {
    validateAmount(purchaseAmount);
    return purchaseAmount / 1000;
  }

  private void validateAmount(int amount) {
    if (amount % 1000 != 0) {
      throw new IllegalArgumentException("[ERROR] 1,000원 단위 숫자로 입력해주세요.");
    }
  }

}
