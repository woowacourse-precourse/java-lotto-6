package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        setUp();
    }

    private void setUp() {
        LottoTicket lottoTicket = LottoTicket.create(inputView.inputBudget());

    }
}
