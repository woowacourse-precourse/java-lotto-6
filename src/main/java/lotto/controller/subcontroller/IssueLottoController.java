package lotto.controller.subcontroller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class IssueLottoController implements Controller {
    public static final int LOTTO_PRICE = 1000;
    private final InputView inputView;
    private final OutputView outputView;

    public IssueLottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
    }
}
