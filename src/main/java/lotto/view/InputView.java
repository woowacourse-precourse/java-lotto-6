package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static String readPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return readLine();
    }

    public static String readWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return readLine();
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return readLine();
    }

    private static String readLine() {
        return Console.readLine();
    }
}