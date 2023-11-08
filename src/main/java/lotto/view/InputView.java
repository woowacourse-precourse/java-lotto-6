package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.message.InputMessage;

public final class InputView {

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(InputMessage.INPUT_AMOUNT_OF_PAYMENT);

        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS);

        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER);

        return Console.readLine();
    }
}
