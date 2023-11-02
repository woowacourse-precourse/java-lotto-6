package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String enterPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String enterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String enterBonusNumbers() {
        System.out.println(ENTER_BONUS_NUMBER);
        return Console.readLine();
    }
}
