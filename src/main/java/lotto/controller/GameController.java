package lotto.controller;

import lotto.domain.*;
import lotto.util.NumberGenerator;
import lotto.util.UniqueRandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private Cash cash;
    private Lottos lottos;
    private Prizes prizes;
    private LottoMachine lottoMachine;
    private WinnerLotto winnerLotto;

    public GameController(
            InputView inputView,
            OutputView outputView,
            NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        createCashAndLottoMachine();
    }

    private void createCashAndLottoMachine() {
        cash = inputView.InputCash();
        lottoMachine = new LottoMachine(numberGenerator, cash);
    }




}
