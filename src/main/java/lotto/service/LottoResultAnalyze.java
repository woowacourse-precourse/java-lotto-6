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

    public Map<String, Integer> calculateResult(LottoTicket lottoTicket, List<Integer> winningNumbers, int bonusNumber) {
        setLottoResult();

        for (int i = 0; i < lottoTicket.getSize(); i++) {
            Lotto lotto = lottoTicket.getLotto(i);
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchingCount = countMatchingNumbers(lottoNumbers, winningNumbers);
            int bonusCount = 0;

            if (lottoNumbers.contains(bonusNumber)) {
                bonusCount = 1;
            }
            LottoRank lottoRank = LottoRank.findByMatchCount(matchingCount, bonusCount);
            if (lottoRank != null) {
                updateLottoResult(lottoRank);
            }
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

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private void updateLottoResult(LottoRank lottoRank) {
        String rank = lottoRank.getRank();
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
    }
}