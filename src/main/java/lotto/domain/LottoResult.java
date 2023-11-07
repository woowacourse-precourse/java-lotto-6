package lotto.domain;

import java.util.*;

public class LottoResult {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    private final Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

    public LottoResult(List<LottoRank> lottoRanks) {
        initLottoResult();
        updateLottoResult(lottoRanks);
    }

    private void initLottoResult() {
        List<LottoRank> ranks = Arrays.stream(LottoRank.values()).toList();
        ranks.stream()
                .forEach(rank -> lottoResult.put(rank, ZERO));
    }

    private void updateLottoResult(List<LottoRank> lottoRanks) {
        lottoRanks.stream()
                .forEach(rank -> lottoResult.put(rank, lottoResult.get(rank) + ONE));
    }

    public int getLottoRewardSum() {
        return lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.FAIL)
                .map(entry -> entry.getKey().calculateReward(entry.getValue()))
                .mapToInt(Integer::intValue).sum();
    }

    public List<Map.Entry<LottoRank, Integer>> getSortedLottoResult() {
        return lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.FAIL)
                .sorted(Comparator.comparingInt(entry -> entry.getKey().getReward()))
                .toList();
    }
}
