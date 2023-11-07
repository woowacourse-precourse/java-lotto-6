package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class inputView {
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getRequestMoney() {
        System.out.println(REQUEST_MONEY);
        return readLine();
    }
    public static String getRequestWinningNumber() {
        System.out.println("\n" +REQUEST_WINNING_NUMBER);
        return readLine();
    }
    public static String getRequestBonusNumber() {
        System.out.println("\n" +REQUEST_BONUS_NUMBER);
        return readLine();
    }
}
