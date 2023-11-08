package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoMatchChecker {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoMatchChecker(List<Integer> winningNumber, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> getResult(List<Lotto> lottos) {
        Map<LottoRank, Integer> rankCount = new LinkedHashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCount.put(lottoRank, 0);
        }
        for (Lotto lotto : lottos) {
            LottoRank rank = getRank(lotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
        return rankCount;
    }

    private LottoRank getRank(Lotto lotto) {
        int matchCount = getMatchCount(lotto.getNumbers());
        boolean bonusMatch = isBonusMatch(lotto, matchCount);
        return LottoRank.of(matchCount, bonusMatch);
    }

    private int getMatchCount(List<Integer> numbers) {
        List<Integer> matchNumbers = new ArrayList<>(winningLotto.getNumbers());
        matchNumbers.retainAll(numbers);
        return matchNumbers.size();
    }

    private boolean isBonusMatch(Lotto lotto, int matchCount) {
        return matchCount == LottoRank.SECOND.getMatchCount() && lotto.getNumbers().contains(bonusNumber);
    }
}
