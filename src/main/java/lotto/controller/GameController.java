package lotto.controller;

import lotto.domain.Cash;
import lotto.domain.Lottos;
import lotto.domain.Prizes;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Cash cash;
    private Lottos lottos;
    private Prizes prizes;

    public GameController(
            InputView inputView,
            OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }



}
