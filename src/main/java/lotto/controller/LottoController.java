package lotto.controller;

import java.util.List;
import lotto.controller.dto.ResultDto;
import lotto.domain.lotto.Lottos;
import lotto.domain.ProfitCalculator;
import lotto.domain.Rank;
import lotto.domain.lotto.WinnerLotto;
import lotto.view.OutputView;

public class LottoController {

    private final ProfitCalculator calculator;
    private final Counter lottoCounter;

    public LottoController(ProfitCalculator calculator,Counter counter) {
        this.calculator = calculator;
        lottoCounter = counter;
    }

    public void run() {
        confirmWinning(buyLotto());
    }

    private Lottos buyLotto() {
        Lottos lottos = lottoCounter.buyLotto();
        OutputView.renderingPurchaseHistory(lottos.getList());
        return lottos;
    }

    private void confirmWinning(Lottos lottos) {
        WinnerLotto winnerLotto = lottoCounter.generateWinnerLotto(lottoCounter.generateLotto());

        List<Rank> confirmResult = lottos.chargeResult(winnerLotto);
        Double profitRate = calculator.calcRate(calculator.calcProfit(confirmResult), lottos.toMoney());

        OutputView.renderingResult(new ResultDto(confirmResult, profitRate));
    }
}
