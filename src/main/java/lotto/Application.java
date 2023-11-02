package lotto;

import lotto.gameUtil.GameLogic;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameLogic gameLogic = new GameLogic();

        outputView.amountMessage();
        int amount = inputView.inputAmount();

        gameLogic.lottoNumber(amount);

        String winningNumberString = inputView.winningNumber();
    }
}
