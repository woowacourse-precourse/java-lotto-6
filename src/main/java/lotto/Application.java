package lotto;

import lotto.controller.Game;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Game game = new Game(lottoMachine, inputView, outputView);
        game.play();
    }
}
