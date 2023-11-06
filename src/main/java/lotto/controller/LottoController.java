package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
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
        Lotto lotto = new Lotto(inputView.inputWinnerNumbers());
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
        LottoGame lottoGame = LottoGame.by(lotto, bonusNumber);
    }

    private void setUp() {
        try {
            LottoTicket lottoTicket = LottoTicket.create(inputView.inputBudget());
            outputView.printTicket(lottoTicket);
        } catch (IllegalArgumentException exception) {
            inputView.printExceptionMessage(exception);
            setUp();
        }
    }
}
