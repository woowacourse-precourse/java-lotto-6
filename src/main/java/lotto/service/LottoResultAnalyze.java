package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultAnalyze {
    private final Map<String, Integer> lottoResult;

    public LottoResultAnalyze() {
        this.lottoResult = new HashMap<>();
    }

    public Map<String, Integer> calculateResult(List<Lotto> lottoTicket, List<Integer> winningNumbers, int bonusNumber) {
        setLottoResult();
        for (int i = 0; i < lottoTicket.size(); i++) {
            Lotto lotto = lottoTicket.get(i);
            int matchingCount = lotto.calculateMatchingCount(winningNumbers);
            int bonusCount = lotto.calculateBonusCount(bonusNumber);
            lotto.updateLottoResult(lottoResult, matchingCount, bonusCount);
        }
        return lottoResult;
    }

    private void setLottoResult() {
        lottoResult.put(LottoRank.FIRST_PLACE.getRank(), 0);
        lottoResult.put(LottoRank.SECOND_PLACE.getRank(), 0);
        lottoResult.put(LottoRank.THIRD_PLACE.getRank(), 0);
        lottoResult.put(LottoRank.FOURTH_PLACE.getRank(), 0);
        lottoResult.put(LottoRank.FIFTH_PLACE.getRank(), 0);
    }
}