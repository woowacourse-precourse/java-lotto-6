package lotto.view;

import lotto.domain.WinningAmount;

public class InputView {

    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static void purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
    }

    public static void winningNumber() {
        System.out.println(WINNING_NUMBERS);
    }

    public static void bonusNumber() {
        System.out.println(BONUS_NUMBER);
    }
}
