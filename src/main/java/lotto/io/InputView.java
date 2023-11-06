package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputPurchasePrice() {
        String purchasePrice = Console.readLine();
        inputValidator.validateNumeric(purchasePrice);
        return purchasePrice;
    }

    public String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        inputValidator.validateDivisionComma(winningNumbers);
        return winningNumbers;
    }

    public String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        inputValidator.validateNumeric(bonusNumber);
        return bonusNumber;
    }
}
