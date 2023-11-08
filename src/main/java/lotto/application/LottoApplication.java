package lotto.application;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.converter.Converter;
import lotto.converter.StringToInteger;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class LottoApplication {

    public void run() {
        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();
        Converter<String, Integer> converter = new StringToInteger();
        InputController inputController = new InputController(converter);
        LottoController lottoController = new LottoController(inputView, outputView, inputController);
        lottoController.run();
    }
}
