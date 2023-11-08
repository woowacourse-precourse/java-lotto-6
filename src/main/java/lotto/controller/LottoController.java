package lotto.controller;

import lotto.domain.Cost;
import lotto.domain.DrawnNumbers;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.dto.DrawnNumbersDto;
import lotto.view.BonusRequestVIew;
import lotto.view.CostRequestView;
import lotto.view.LottoResultView;
import lotto.view.View;
import lotto.view.WinningRequestView;

public class LottoController {
    public void run() {
        Cost cost = Cost.from(CostRequestView.request());
        Lottos lottos = issue(cost.getCount());
        DrawnNumbers drawnNumbers = draw();
        conclude(lottos, drawnNumbers, cost);
    }

    private Lottos issue(int count) {
        Lottos lottos = Lottos.from(count);
        LottoResultView.printLottos(lottos);
        return lottos;
    }

    private DrawnNumbers draw() {
        DrawnNumbersDto dto = DrawnNumbersDto.of(WinningRequestView.request(), BonusRequestVIew.request());
        return DrawnNumbers.from(dto);
    }

    private void conclude(Lottos lottos, DrawnNumbers drawnNumbers, Cost cost) {
        WinningResult winningResult = WinningResult.of(lottos, drawnNumbers);
        View.printWinningResult(winningResult, cost);
    }
}
