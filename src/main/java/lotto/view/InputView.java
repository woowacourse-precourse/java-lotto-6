package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.PurchaseInputValidator;
import lotto.validation.BonusInputValidator;
import lotto.validation.CommonErrorValidator;
import lotto.validation.WinningNumbersInputValidator;

public class InputView {

    private final PurchaseInputValidator purchaseInput;
    private final WinningNumbersInputValidator winningNumbersInput;
    private final BonusInputValidator bonusNumberInput;
    private final CommonErrorValidator commonErrorValidator;

    public InputView() {
        this.purchaseInput = new PurchaseInputValidator();
        this.winningNumbersInput = new WinningNumbersInputValidator();
        this.bonusNumberInput = new BonusInputValidator();
        this.commonErrorValidator = new CommonErrorValidator();
    }

    public String readAmountInput() {
        while (true) {
            try {
                String input = Console.readLine();
                commonErrorValidator.validateCommonError(input);
                purchaseInput.validateAmountInput(input);
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
                commonErrorValidator.validateNullEmptySpace(input);
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
                commonErrorValidator.validateCommonError(input);
                bonusNumberInput.validateBonusNumberInput(winningNumbers, input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
