package lotto.controller;

import lotto.model.LottoManager;
import lotto.model.Token;
import lotto.util.RepeatModule;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController extends RepeatModule {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoManager lottoManager;

    public MainController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        Token token = repeat(inputView::readToken);
        lottoManager = new LottoManager(token);
    }
}
