package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputLottoPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        return Console.readLine();
    }
}
