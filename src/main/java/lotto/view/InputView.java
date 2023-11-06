package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.AmountInputValidator;
import lotto.validation.CommonValidator;
import lotto.validation.WinningNumbersInputValidator;

public class InputView {

    private final AmountInputValidator amountInput;
    private final WinningNumbersInputValidator winningNumbersInput;
    private final CommonValidator commonValidator;

    public InputView() {
        this.amountInput = new AmountInputValidator();
        this.winningNumbersInput = new WinningNumbersInputValidator();
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

    public String readWinningNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                commonValidator.validateNullEmptySpace(input);
                winningNumbersInput.validateWinningNumbers(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
