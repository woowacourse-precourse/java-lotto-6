package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
  public int purchaseAmount() {
    System.out.println("로또 구입 금액을 입력하세요.");
    int numberOfTickets = lotto_purchase();
    System.out.println(numberOfTickets + "개를 구매했습니다.");
    return numberOfTickets;
  }

  private int lotto_purchase() {
    while (true) {
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            validateAmount(purchaseAmount);  
            return purchaseAmount / 1000;  
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 입력입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

private void validateAmount(int amount) {
    if (amount % 1000 != 0) {
        throw new IllegalArgumentException("[ERROR] 1,000원 단위 숫자로 입력해주세요.");
    }
}

}
