package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;

public class InputView {
    private PurchasePriceValidator purchasePriceValidator;
    private WinnerNumberValidator winnerNumberValidator;
    private BonusNumberValidator bonusNumberValidator;

    public InputView(PurchasePriceValidator purchasePriceValidator,
                     WinnerNumberValidator winnerNumberValidator,
                     BonusNumberValidator bonusNumberValidator) {
        this.purchasePriceValidator = purchasePriceValidator;
        this.winnerNumberValidator = winnerNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }


    public int inputPurchasePrice() {
        String inputPrice = readLine();
        return purchasePriceValidate(inputPrice);
    }

    public List<Integer> inputWinnerNumber() {
        String inputWinnerNumber = readLine();
        return winnerNumberValidate(inputWinnerNumber);
    }

    public int inputBonusNumber() {
        String inputBonusNumber = readLine();
        return bonusNumberValidate(inputBonusNumber);
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
