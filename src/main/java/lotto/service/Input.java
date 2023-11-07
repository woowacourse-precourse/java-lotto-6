package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static final String MESSAGE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String MESSAGE_ENTER_WINNING_NUMBERS="당첨 번호를 입력해 주세요.";
    public static final String MESSAGE_ENTER_BONUS_NUMBER="보너스 번호를 입력해 주세요.";

    public static String getPurchaseAmount() {
        System.out.println(MESSAGE_ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String getWinningNumber() {
        System.out.println();
        System.out.println(MESSAGE_ENTER_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println();
        System.out.println(MESSAGE_ENTER_BONUS_NUMBER);
        return Console.readLine();
    }
}
