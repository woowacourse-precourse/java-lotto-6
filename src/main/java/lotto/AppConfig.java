package lotto;

import lotto.service.LottoGenerator;
import lotto.service.LottoProfitCalculator;
import lotto.validator.LottoPayAmountValidator;
import lotto.validator.Validator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.View;

public class AppConfig {

    public View createView() {
        return new View();
    }

    public LottoGenerator createLottoGenerator() {
        return new LottoGenerator();
    }

    public LottoProfitCalculator createLottoProfitCalculator() {
        return new LottoProfitCalculator();
    }

    public Validator createPayAmountValidator() {
        return new LottoPayAmountValidator();
    }

    public Validator createWinningNumbersValidator() {
        return new WinningNumbersValidator();
    }

}
