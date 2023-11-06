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

    public String inputLotto() {
        String lotto = Console.readLine();
        inputValidator.validateDivisionComma(lotto);
        return lotto;
    }

    public String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        inputValidator.validateNumeric(bonusNumber);
        return bonusNumber;
    }
}
