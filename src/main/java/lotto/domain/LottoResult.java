package lotto.domain;

import java.util.*;

public class LottoResult {
    private final static int ONE = 1;

    private final Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

    public LottoResult(List<LottoRank> lottoRanks) {
        initLottoResult();
        updateLottoResult(lottoRanks);
    }

    private void initLottoResult() {
        List<LottoRank> ranks = Arrays.stream(LottoRank.values()).toList();
        for (LottoRank rank : ranks) {
            lottoResult.put(rank, 0);
        }
    }

    private void updateLottoResult(List<LottoRank> lottoRanks) {
        for (LottoRank rank : lottoRanks) {
            int count = lottoResult.get(rank) + ONE;
            lottoResult.put(rank, count);
        }
    }

    public int calculateLottoReward() {

        return lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.FAIL)
                .map(entry -> LottoRank.calculateReward(entry.getKey(), entry.getValue()))
                .mapToInt(Integer::intValue).sum();
    }
}
