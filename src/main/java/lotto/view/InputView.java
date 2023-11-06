package lotto.view;

import static lotto.validator.Validator.validateNumeric;
import static lotto.constant.ViewConstant.ASK_PAYMENT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readPayment() {
        System.out.println(ASK_PAYMENT_MESSAGE);

        String payment = Console.readLine();
        validateNumeric(payment);
        return Integer.parseInt(payment);
    }

}
