package lotto;

import lotto.controller.LottoGameController;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        PriceValidator priceValidator = new PriceValidator();
        WinnerNumberValidator winnerNumberValidator = new WinnerNumberValidator();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

        InputView inputView = new InputView(priceValidator, winnerNumberValidator, bonusNumberValidator);
        OutputView outputView = new OutputView();

        LottoGameController lottoGameController = new LottoGameController(inputView, outputView);

        lottoGameController.start();

    }
}
