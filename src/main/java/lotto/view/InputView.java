package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputMoney() {
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
