package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.AmountInputValidator;
import lotto.validation.CommonValidator;

public class InputView {

    private final AmountInputValidator amountInput;
    private final CommonValidator commonValidator;

    public InputView() {
        this.amountInput = new AmountInputValidator();
        this.commonValidator = new CommonValidator();
    }

    public String readAmountInput() {
        while (true) {
            try {
                String input = Console.readLine();
                commonValidator.validateNullEmptySpace(input);
                amountInput.validateAmountInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
