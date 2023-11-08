package lotto.v3.controller;

import lotto.v3.model.LottoRank;
import lotto.v3.model.LottoResult;
import lotto.v3.service.LottoYieldCalculatorService;
import lotto.v3.view.LottoYieldView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoYieldController {
    private final LottoYieldView view;
    private final LottoYieldCalculatorService yieldCalculatorService;

    public LottoYieldController(LottoYieldView view, LottoYieldCalculatorService yieldCalculatorService) {
        this.view = view;
        this.yieldCalculatorService = yieldCalculatorService;
    }

    public void processLottoYield(List<List<Integer>> purchasedNumbers, Set<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> matchCounts = result.getMatchCounts();
        double yield = yieldCalculatorService.calculateYield(matchCounts, purchasedNumbers.size());
        view.displayResults(matchCounts, yield);

    }
}





