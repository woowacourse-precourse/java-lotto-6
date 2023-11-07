package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.PurchaseInputValidator;
import lotto.validation.BonusInputValidator;
import lotto.validation.CommonInputValidator;
import lotto.validation.WinningNumbersInputValidator;

public class InputView {

    private final PurchaseInputValidator amountInput;
    private final WinningNumbersInputValidator winningNumbersInput;
    private final BonusInputValidator bonusNumberInput;
    private final CommonInputValidator commonInputValidator;

    public InputView() {
        this.amountInput = new PurchaseInputValidator();
        this.winningNumbersInput = new WinningNumbersInputValidator();
        this.bonusNumberInput = new BonusInputValidator();
        this.commonInputValidator = new CommonInputValidator();
    }

    public String readAmountInput() {
        while (true) {
            try {
                String input = Console.readLine();
                commonInputValidator.validateCommonError(input);
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
                commonInputValidator.validateNullEmptySpace(input);
                winningNumbersInput.validateWinningNumbers(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readBonusNumber(String winningNumbers) {
        while (true) {
            try {
                String input = Console.readLine();
                commonInputValidator.validateCommonError(input);
                bonusNumberInput.validateBonusNumberInput(winningNumbers, input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
