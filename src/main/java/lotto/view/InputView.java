package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validation.ValidInput;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private String paymentInput;
    private ValidInput validInput;

    public InputView() {
        validInput = new ValidInput();
    }

    public String getUserInput() {
        String input = Console.readLine();
        return input;
    }

    public String askPayment() {
        paymentInput = getUserInput();
        try {
            validInput.validPayment(paymentInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askPayment();
        }
        return paymentInput;
    }

}
