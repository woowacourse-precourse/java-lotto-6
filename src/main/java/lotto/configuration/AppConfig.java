package lotto.configuration;

import lotto.GameManager;
import lotto.controller.*;
import lotto.domain.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private NumberGenerator numberGenerator() {
        return new NumberGenerator();
    }

    private MoneyController moneyController() {
        return new MoneyController();
    }

    private LottosController lottosController() {
        return new LottosController();
    }

    private LottoController lottoController() {
        return new LottoController();
    }

    private BonusController bonusController() {
        return new BonusController();
    }

    private ResultController resultController() {
        return new ResultController();
    }

    public GameManager gameManager() {
        return new GameManager(
                inputView(),
                outputView(),
                numberGenerator(),
                moneyController(),
                lottosController(),
                lottoController(),
                bonusController(),
                resultController());
    }

}
