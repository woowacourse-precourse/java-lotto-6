package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPayment() {
        System.out.println(INPUT_PAYMENT);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
