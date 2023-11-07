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
    private String bonusNumberInput;
    private ValidInput validInput;

    public InputView() {
        validInput = new ValidInput();
    }

    private String getUserInput() {
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

    public String askBonusNumber() {
        bonusNumberInput = getUserInput();
        try {
            validInput.validBonusNumber(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askBonusNumber();
        }
        return bonusNumberInput;
    }

}
