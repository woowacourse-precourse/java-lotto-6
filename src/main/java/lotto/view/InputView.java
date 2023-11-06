package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println("\n" + INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("\n" + INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
