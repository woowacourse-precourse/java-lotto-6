package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.enums.ViewMessageType.*;
import static lotto.enums.ViewMessageType.INPUT_PAYMENT;

public class InputView {
    public static String inputPayment() {
        System.out.print(INPUT_PAYMENT.getMessage());
        return readLine().strip();
    }

    public static String inputWinningNumbers() {
        System.out.print(INPUT_WINNING_NUMBERS.getMessage());
        return readLine().strip();
    }

    public static String inputBonusNumber() {
        System.out.print(INPUT_BONUS_NUMBER.getMessage());
        return readLine().strip();
    }
}
