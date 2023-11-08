package lotto.controller;

import static lotto.global.constants.NumberType.COST_UNIT;
import static lotto.view.View.requestBonusNumber;
import static lotto.view.View.requestWinningNumbers;

import lotto.domain.Cost;
import lotto.domain.DrawnNumbers;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.dto.DrawnNumbersDto;
import lotto.view.CostRequestView;
import lotto.view.View;

public class LottoController {
    public void run() {
        Cost cost = Cost.from(CostRequestView.request());
        Lottos lottos = issue(cost.getCount());
        DrawnNumbers drawnNumbers = draw();
        conclude(lottos, drawnNumbers, cost);
    }

    private Lottos issue(int count) {
        Lottos lottos = Lottos.from(count);
        View.printLottos(lottos);
        return lottos;
    }

    private DrawnNumbers draw() {
        DrawnNumbersDto dto = DrawnNumbersDto.of(requestWinningNumbers(), requestBonusNumber());
        return DrawnNumbers.from(dto);
    }

    private void conclude(Lottos lottos, DrawnNumbers drawnNumbers, int cost) {
        WinningResult winningResult = WinningResult.of(lottos, drawnNumbers);
        View.printWinningResult(winningResult, cost);
    }

    private int getCountFrom(int cost) {
        return cost / COST_UNIT.getValue();
    }
}
