package lotto;

import lotto.controller.LottoController;
import lotto.model.ReturnCalculator;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PayAmountValidator;
import lotto.validator.Validator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.View;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController();
    }

    public View view() {
        return new View();
    }

    public Validator payAmountValidator() {
        return new PayAmountValidator();
    }

    public Validator winningNumbersValidator() {
        return new WinningNumbersValidator();
    }

    public Validator bonusNumberValidator() {
        return new BonusNumberValidator();
    }

    public ReturnCalculator returnCalculator() {
        return new ReturnCalculator();
    }
}
