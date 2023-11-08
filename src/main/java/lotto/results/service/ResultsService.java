package lotto.results.service;

import java.util.List;
import lotto.results.domain.Results;

public class ResultsService {
    private final Results results;

    public ResultsService(Results results) {
        this.results = results;
    }

    public List<Integer> insultWinningNumbersWithBonusNumber() {
        results.insultWinningNumbers();
        results.insultBonus();
        return results.getWinningNumbersWithBonus();
    }
}
