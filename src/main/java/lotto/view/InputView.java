package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private static String read() {
        return readLine();
    }

    public static String purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return read();
    }

    public static String winningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return read();
    }

    public static String bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return read();
    }
}
