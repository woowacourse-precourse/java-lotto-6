package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int requestLottoPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String stringPurchaseAmount = Console.readLine();

            try {
                return Integer.parseInt(stringPurchaseAmount);
            } catch (NumberFormatException e) {
                System.err.print("[ERROR] 올바른 입력이 아닙니다. ");
            }
        }
    }
}
