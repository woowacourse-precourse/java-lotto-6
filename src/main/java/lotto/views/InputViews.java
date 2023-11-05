package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public class InputViews {
    static final String PURCHASE_INPUT_MESS = "구입금액을 입력해 주세요.";
    static final String WINNING_NUM_INPUT_MESS = "당첨 번호를 입력해 주세요.";
    static final String WRITING_BONUS_NUM_MESS = "보너스 번호를 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println(PURCHASE_INPUT_MESS);
        return Console.readLine();
    }

    public static String readWinningNum() {
        System.out.println(WINNING_NUM_INPUT_MESS);
        return Console.readLine();
    }

    public static String readBonusNum() {
        System.out.println(WRITING_BONUS_NUM_MESS);
        return Console.readLine();
    }
}
