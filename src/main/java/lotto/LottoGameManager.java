package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameManager {

    public int inputPurchaseAmount() {
        int purchaseAmount = 1000;
        String input = Console.readLine();

        System.out.println("로또 구입 금액을 입력하세요: ");
        while(true) {
            try {
                Integer.parseInt(input);
                purchaseAmount = Integer.parseInt(input);
                if (purchaseAmount % 1000 == 0) {
                    return purchaseAmount;
                } else {
                    throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            }
        }
    }
}
