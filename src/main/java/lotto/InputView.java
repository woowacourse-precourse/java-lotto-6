package lotto;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public static String playerInput() {
        return Console.readLine();
    }

    public static int getPurchaseAmount() {
        try {
            System.out.println("구입 금액을 입력해 주세요");
            String input = playerInput().trim();
            if (!input.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount < 0) {
                throw new IllegalArgumentException("[ERROR] 음수 값을 입력할 수 없습니다.");
            }
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
