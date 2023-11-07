package lotto.controller;

import lotto.global.SingletonRegistry;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LottoController getInstance(InputView inputView, OutputView outputView){
        String key = "LottoController";
        if (SingletonRegistry.getInstance(key) == null) {
            SingletonRegistry.register(key, new LottoController(inputView, outputView));
        }
        return (LottoController) SingletonRegistry.getInstance(key);
    }
}