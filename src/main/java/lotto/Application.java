package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        InputProcessor inputProcessor = new InputProcessor();
        LottoController lottoController = new LottoController(outputView, inputView, inputProcessor);
        lottoController.start();
    }
}
