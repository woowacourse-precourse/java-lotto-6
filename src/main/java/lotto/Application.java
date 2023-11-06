package lotto;

import lotto.domain.LottoResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoResultCalculator resultCalculator = new LottoResultCalculator();
        GameManager gameManager = new GameManager(inputView, outputView, resultCalculator);
        gameManager.gameStart();
    }
}
