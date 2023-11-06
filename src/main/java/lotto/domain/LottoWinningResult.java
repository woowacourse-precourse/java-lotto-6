package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.config.Message;

public class LottoWinningResult {

    private final Map<LottoRank, Integer> lottoRankCounts;

    private LottoWinningResult(Map<LottoRank, Integer> lottoRankCounts) {
        this.lottoRankCounts = lottoRankCounts;
    }

    public static LottoWinningResult of(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoRankCounts = getLottoRankCounts(lottos, winningLotto);
        return new LottoWinningResult(lottoRankCounts);
    }

    private static Map<LottoRank, Integer> getLottoRankCounts(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoRankCounts = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = getLottoRank(winningLotto, lotto);
            if (lottoRank == LottoRank.MISS) {
                continue;
            }
            lottoRankCounts.put(lottoRank, lottoRankCounts.getOrDefault(lottoRank, 0) + 1);
        }
        return lottoRankCounts;
    }

    private static LottoRank getLottoRank(WinningLotto winningLotto, Lotto lotto) {
        int matchingNumberCount = winningLotto.countMatchingNumbersWith(lotto);
        boolean isBonusNumberMatch = winningLotto.isBonusNumberIn(lotto);
        return LottoRank.getLottoRank(matchingNumberCount, isBonusNumberMatch);
    }

    public String getLottoRankMessages() {
        StringJoiner lottoRankMessageMaker = new StringJoiner(Message.NEW_LINE);
        for (LottoRank lottoRank : LottoRank.values()) {
            String lottoRankMessage = getLottoRankMessage(lottoRank);
            lottoRankMessageMaker.add(lottoRankMessage);
        }
        return lottoRankMessageMaker.toString();
    }

    private String getLottoRankMessage(LottoRank lottoRank) {
        int lottoRankCount = lottoRankCounts.getOrDefault(lottoRank, 0);
        return lottoRank.getLottoRankMessage(lottoRankCount);
    }

    public float calculateWinningRate() {
        return 0;
    }
}
