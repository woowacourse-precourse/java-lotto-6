package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.converter.StringToInteger;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();
        StringToInteger stringToInteger = new StringToInteger();
        InputController inputController = new InputController(stringToInteger);
        LottoController lottoController = new LottoController(inputView, outputView, inputController);
        lottoController.run();
    }
}
