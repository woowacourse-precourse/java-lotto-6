package lotto.controller.outputController;


import lotto.model.lottoResultChecker.LottoRank;
import lotto.model.lottoResultChecker.LottoReturnsCalculator;
import lotto.view.outputView.LottoReturnsOutput;

import java.util.Map;

public class LottoReturnsController {
    private final LottoReturnsCalculator returnsCalculator;
    private final LottoReturnsOutput returnsOutput;

    public LottoReturnsController(LottoReturnsCalculator returnsCalculator, LottoReturnsOutput returnsOutput) {
        this.returnsCalculator = returnsCalculator;
        this.returnsOutput = returnsOutput;
    }

    public void displayReturnRate(Map<LottoRank, Integer> rankResults, int ticketCost) {
        double returnRate = returnsCalculator.calculateReturnRate(rankResults);
        returnsOutput.displayReturnRate(returnRate);
    }
}
