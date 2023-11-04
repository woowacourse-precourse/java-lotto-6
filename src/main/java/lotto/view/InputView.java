package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.GameMessage;
import lotto.message.ValidateErrorMessage;

public class InputView {
    public int getPayment() {
        try {
            System.out.println(GameMessage.PAYMENT_INPUT_MESSAGE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateErrorMessage.PAYMENT_ERROR.getMessage());
        }
    }
}