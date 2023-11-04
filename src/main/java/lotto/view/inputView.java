package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getRequestMoney() {
        System.out.println(REQUEST_MONEY);
        return Console.readLine();
    }
    public static String getRequestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        return Console.readLine();
    }
    public static String getRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
