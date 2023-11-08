package lotto.lottoResults.service;

import java.util.List;
import lotto.lottoResults.domain.LottoResults;

public class LottoResultsService {
    private final LottoResults lottoResults;

    public LottoResultsService(LottoResults lottoResults) {
        this.lottoResults = lottoResults;
    }

    public List<Integer> insultWinningNumbersWithBonusNumber() {
        lottoResults.insultWinningNumbers();
        lottoResults.insultBonus();
        return lottoResults.getWinningNumbersWithBonus();
    }
}
