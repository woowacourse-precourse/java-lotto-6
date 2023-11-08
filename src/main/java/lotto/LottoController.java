package lotto;

import java.util.List;

public class LottoController {
    private final LottoView view;
    private final LottoMachine machine;

    public LottoController(LottoView view, LottoMachine machine) {
        this.view = view;
        this.machine = machine;
    }

    public void playLottoGame() {
        int purchaseAmount = view.getPurchaseAmount();
        List<Lotto> lottos = machine.purchaseLottos(purchaseAmount);
        view.displayLottos(lottos);

        Lotto winningLotto = view.getWinningLotto();
        int bonusNumber = view.getBonusNumber();

        LottoResult result = machine.checkResults(lottos, winningLotto, bonusNumber);
        view.displayResults(result);
    }
}