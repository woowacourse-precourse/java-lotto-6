package lotto.controller;

import lotto.domain.amount.Amount;
import lotto.domain.lotto.Lottos;
import lotto.utils.generator.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Amount amount = initAmount();
        final Lottos lottos = purchaseLottos(amount);
        announceLottos(lottos);
    }

    public Amount initAmount() {
        return new Amount(inputView.readAmount());
    }

    public Lottos purchaseLottos(final Amount amount) {
        final int lottoCount = amount.getDividedAmount();
        return new Lottos(lottoCount, new RandomNumberGenerator());
    }

    public void announceLottos(Lottos lottos) {
        outputView.printLottoCount(lottos.getLottoStatus());
        outputView.printLottoStatus(lottos.getLottoStatus());
    }
}
