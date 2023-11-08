package lotto.domain;

import lotto.domain.number.NumberStrategy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoDraw {
    private final List<Lotto> lottoTickets;

    public LottoDraw(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private static final Map<LottoResult, Integer> resultCounts = new EnumMap<>(LottoResult.class);

    public Map<LottoResult, Integer> extractResult(NumberStrategy winningLotto, int bonusNumber) {
        for (LottoResult result : LottoResult.values()) {
            resultCounts.put(result, 0);
        }

        calculateResult(winningLotto.generateNumber(), bonusNumber);

        return resultCounts;
    }

    private void calculateResult(Lotto winningLotto, int bonusNumber) {
        lottoTickets.forEach(lottoTicket -> {
            int matchingCount = compareLotto(winningLotto, lottoTicket.getNumbers());
            boolean bonusMatch = compareBonus(bonusNumber, lottoTicket.getNumbers());
            setMatchingResult(matchingCount, bonusMatch);
        });
    }

    private int compareLotto(Lotto winningLotto, List<Integer> lottoNumbers) {
        List<Integer> copiedLottoNumbers = new ArrayList<>(lottoNumbers);
        copiedLottoNumbers.retainAll(winningLotto.getNumbers());
        return copiedLottoNumbers.size();
    }

    private void setMatchingResult(int matchingCount, boolean bonusMatch) {
        for (LottoResult result : LottoResult.values()) {
            if (result.isBonusMatch(bonusMatch)) {
                continue;
            }
            if (matchingCount == result.getMatchedNumbers()) {
                resultCounts.put(result, resultCounts.get(result) + 1);
                return;
            }
        }
    }

    private boolean compareBonus(int bonusNumber, List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
