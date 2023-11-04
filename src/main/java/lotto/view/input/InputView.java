package lotto.view.input;

import java.util.List;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.Template.InputValidatorTemplate;

public class InputView {
    private final PurchasePriceValidator purchasePriceValidator;
    private final WinnerNumberValidator winnerNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;

    private final InputValidatorTemplate template;

    public InputView(PurchasePriceValidator purchasePriceValidator,
                     WinnerNumberValidator winnerNumberValidator,
                     BonusNumberValidator bonusNumberValidator, InputValidatorTemplate template) {
        this.purchasePriceValidator = purchasePriceValidator;
        this.winnerNumberValidator = winnerNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
        this.template = template;
    }

    public int inputPurchasePrice() {
        return template.InputWithValidation(this::purchasePriceValidate);
    }

    public List<Integer> inputWinnerNumber() {
        return template.InputWithValidation(this::winnerNumberValidate);
    }

    public int inputBonusNumber() {
        return template.InputWithValidation(this::bonusNumberValidate);
    }

    private int purchasePriceValidate(String inputPrice) {
        purchasePriceValidator.isNullOrEmpty(inputPrice);
        return purchasePriceValidator.isInteger(inputPrice);
    }

    private List<Integer> winnerNumberValidate(String inputWinnerNumber) {
        winnerNumberValidator.isNullOrEmpty(inputWinnerNumber);
        winnerNumberValidator.validateErrorInput(inputWinnerNumber);
        return winnerNumberValidator.isSizeEqualToSix(inputWinnerNumber);
    }

    private int bonusNumberValidate(String inputBonusNumber) {
        bonusNumberValidator.isNullOrEmpty(inputBonusNumber);
        return bonusNumberValidator.isInteger(inputBonusNumber);
    }
}
