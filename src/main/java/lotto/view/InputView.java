package lotto.view;

import static lotto.util.Constants.LINE;

import lotto.util.exception.input.ConstructionErrorException;

public class InputView {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {
        throw new ConstructionErrorException();
    }

    public static void promptForPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
    }

    public static void promptForWinningNumbers() {
        System.out.println(LINE + ENTER_WINNING_NUMBERS);
    }

    public static void promptForBonusNumber() {
        System.out.println(LINE + ENTER_BONUS_NUMBER);
    }
}
