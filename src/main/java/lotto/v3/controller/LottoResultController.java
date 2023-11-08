package lotto.v3.controller;

import lotto.v3.model.LottoResult;
import lotto.v3.view.LottoResultView;
import java.util.List;
import java.util.Set;

public class LottoResultController {
    private final LottoResultView view;

    public LottoResultController(LottoResultView view) {
        this.view = view;
    }

    public void showResults(List<List<Integer>> purchasedNumbers, Set<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);
        view.displayResults(result.getMatchCounts());
    }
}

