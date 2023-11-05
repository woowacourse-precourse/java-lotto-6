package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int enterLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine()
                .trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자이어야 합니다.");
        }
    }
}
