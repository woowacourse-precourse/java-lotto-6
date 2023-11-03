package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PriceValidator;
import lotto.validation.WinnerNumberValidator;

public class InputView {
    private PriceValidator priceValidator;
    private WinnerNumberValidator winnerNumberValidator;
    private BonusNumberValidator bonusNumberValidator;

    public InputView(PriceValidator priceValidator,
                     WinnerNumberValidator winnerNumberValidator,
                     BonusNumberValidator bonusNumberValidator) {
        this.priceValidator = priceValidator;
        this.winnerNumberValidator = winnerNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }


    public int inputPrice() {
        String inputPrice = readLine();
        return priceValidate(inputPrice);
    }

    public List<Integer> inputWinnerNumber() {
        String inputWinnerNumber = readLine();
        return winnerNumberValidate(inputWinnerNumber);
    }

    public int inputBonusNumber() {
        String inputBonusNumber = readLine();
        return bonusNumberValidate(inputBonusNumber);
    }

    private int priceValidate(String inputPrice) {
        priceValidator.isNullOrEmpty(inputPrice);
        return priceValidator.isInteger(inputPrice);
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
