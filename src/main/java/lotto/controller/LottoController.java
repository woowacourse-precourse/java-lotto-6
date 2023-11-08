package lotto.controller;

import lotto.domain.Cost;
import lotto.domain.DrawnNumbers;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.view.BonusRequestVIew;
import lotto.view.CostRequestView;
import lotto.view.LottoResultView;
import lotto.view.WinningRequestView;
import lotto.view.WinningResultView;

public class LottoController {
    public void run() {
        Cost cost = Cost.from(CostRequestView.request());
        Lottos lottos = issue(cost.getCount());
        DrawnNumbers drawnNumbers = draw();
        conclude(lottos, drawnNumbers, cost);
    }

    private Lottos issue(final int count) {
        Lottos lottos = Lottos.from(count);
        LottoResultView.print(lottos);
        return lottos;
    }

    private DrawnNumbers draw() {
        return DrawnNumbers.from(WinningRequestView.request(), BonusRequestVIew.request());
    }

    private void conclude(final Lottos lottos, final DrawnNumbers drawnNumbers, final Cost cost) {
        WinningResult winningResult = WinningResult.of(lottos, drawnNumbers);
        WinningResultView.print(winningResult, cost);
    }
}
