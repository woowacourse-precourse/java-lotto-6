package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputMessage;

public final class InputView {

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(InputMessage.INPUT_AMOUNT_OF_PAYMENT.getMessage());

        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.getMessage());

        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());

        return Console.readLine();
    }
}
