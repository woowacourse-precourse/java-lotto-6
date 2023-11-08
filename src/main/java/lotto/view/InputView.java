package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
