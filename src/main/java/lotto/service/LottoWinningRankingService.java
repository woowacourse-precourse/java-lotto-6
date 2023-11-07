package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningRanking;
import lotto.domain.Lottos;
import lotto.vo.LottoNumber;
import lotto.vo.LottoWinningNumbers;

import java.util.EnumMap;

public class LottoWinningRankingService {
    private static final LottoWinningRankingService instance = new LottoWinningRankingService();

    private LottoWinningRankingService() {}

    public static LottoWinningRankingService getInstance() {
        return instance;
    }

    public EnumMap<LottoWinningRanking, Integer> countWinningRankings(final Lottos userLottos, final LottoWinningNumbers winningLotto) {
        EnumMap<LottoWinningRanking, Integer> rankingCountMap = new EnumMap<>(LottoWinningRanking.class);

        for (Lotto lotto : userLottos.lottoGroup()) {
            int matchedNumberCount = countMatchedNumbers(lotto, winningLotto);
            boolean needsBonusNumber = hasBonusNumber(lotto, winningLotto);
            LottoWinningRanking ranking = calculateRanking(matchedNumberCount, needsBonusNumber);
            rankingCountMap.put(ranking, rankingCountMap.getOrDefault(ranking, 0) + 1);
        }

        return rankingCountMap;
    }

    private int countMatchedNumbers(final Lotto lotto, final LottoWinningNumbers winningLotto) {
        int matchedNumberCount = 0;
        for (LottoNumber number : winningLotto.lotto().getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                matchedNumberCount++;
            }
        }
        return matchedNumberCount;
    }

    private boolean hasBonusNumber(final Lotto lotto, final LottoWinningNumbers lottoWinningNumbers) {
        return lotto.containsBonusNumber(lottoWinningNumbers.lottoWinningBonusNumber());
    }

    private LottoWinningRanking calculateRanking(final int matchedNumberCount, final boolean needsBonusNumber) {
        LottoWinningRanking ranking = LottoWinningRanking.NONE;
        for (LottoWinningRanking value : LottoWinningRanking.values()) {
            if (isMatchingRanking(value, matchedNumberCount, needsBonusNumber)) {
                ranking = value;
            }
        }

        return ranking;
    }

    private boolean isMatchingRanking(final LottoWinningRanking ranking, final int matchedNumberCount, final boolean needsBonusNumber) {
        return matchedNumberCount == ranking.getMatchedNumberCount()
                && (needsBonusNumber || !ranking.getNeedsBonusNumber());
    }
}
