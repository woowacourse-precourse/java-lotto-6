package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final static String ASK_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String ASK_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT_MESSAGE);
        return readLine();
    }

    public static String askWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        return readLine();
    }

    public static String askBonusNumberMessage() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        return readLine();
    }
}
