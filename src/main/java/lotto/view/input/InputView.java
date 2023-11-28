package lotto.view.input;

import java.util.List;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.template.InputValidatorTemplate;

public class InputView {
    private final PurchasePriceValidator purchasePriceValidator;
    private final WinnerNumberValidator winnerNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final InputValidatorTemplate template;

    public InputView(PurchasePriceValidator purchasePriceValidator, WinnerNumberValidator winnerNumberValidator,
                     BonusNumberValidator bonusNumberValidator, InputValidatorTemplate template) {
        this.purchasePriceValidator = purchasePriceValidator;
        this.winnerNumberValidator = winnerNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
        this.template = template;
    }


    public int readPrice() {
        return template.InputWithValidation(this::purchasePriceValidate);
    }

    public List<Integer> inputWinnerNumber() {
        return template.InputWithValidation(this::WinnerNumberValidate);
    }

    public int inputBonusNumber() {
        return template.InputWithValidation(this::BonusNumberValidate);
    }

    private int purchasePriceValidate(String input) {
        purchasePriceValidator.isNullOrEmpty(input);
        int purchasePrice = purchasePriceValidator.isInteger(input);
        return purchasePriceValidator.moreThanOne(purchasePrice);
    }


    private List<Integer> WinnerNumberValidate(String input) {
        winnerNumberValidator.isNullOrEmpty(input);
        winnerNumberValidator.checkCommaError(input);
        List<Integer> winnerNumber = winnerNumberValidator.isInteger(input);
        return winnerNumberValidator.moreThanOne(winnerNumber);
    }

    private int BonusNumberValidate(String input) {
        bonusNumberValidator.isNullOrEmpty(input);
        int bonusNumber = bonusNumberValidator.isInteger(input);
        return bonusNumberValidator.moreThanOne(bonusNumber);
    }
}
