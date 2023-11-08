package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import lotto.domain.strategy.IssuableStrategy;
import lotto.dto.LottoNumbersDto;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final int totalCount, final IssuableStrategy issuableStrategy) {
        this.lottos = createLottos(totalCount, issuableStrategy);
    }

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(final int totalCount, final IssuableStrategy issuableStrategy) {
        return IntStream.rangeClosed(1, totalCount)
                .mapToObj(count -> issuableStrategy.issue())
                .toList();
    }

    public int count() {
        return lottos.size();
    }

    public EnumMap<Rank, Integer> getRankResult(final WinningLotto winningLotto) {
        EnumMap<Rank, Integer> rankResult = initializeRankResultWithDefaultValue();
        for (Lotto lotto : lottos) {
            Rank matchedRank = findMatchedRank(winningLotto, lotto);
            addWinningCountInValidRank(matchedRank, rankResult);
        }
        return rankResult;
    }

    private EnumMap<Rank, Integer> initializeRankResultWithDefaultValue() {
        EnumMap<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
        int defaultValue = 0;
        for (Rank rank : Rank.values()) {
            if (isValidRank(rank)) {
                rankResult.put(rank, defaultValue);
            }
        }
        return rankResult;
    }

    private Rank findMatchedRank(final WinningLotto winningLotto, final Lotto lotto) {
        int matchingCount = winningLotto.countMatchingNumber(lotto);
        boolean bonusNumberExistence = winningLotto.hasBonusNumber(lotto);
        return Rank.find(matchingCount, bonusNumberExistence);
    }

    private void addWinningCountInValidRank(final Rank matchedRank, final EnumMap<Rank, Integer> rankResult) {
        if (isValidRank(matchedRank)) {
            rankResult.put(matchedRank, rankResult.getOrDefault(matchedRank, 0) + 1);
        }
    }

    private boolean isValidRank(final Rank result) {
        return !result.isUnranked();
    }

    public long calculateTotalReward(final EnumMap<Rank, Integer> rankResult) {
        long totalReward = 0L;
        for (Entry<Rank, Integer> rankResultEntry : rankResult.entrySet()) {
            totalReward += calculateReward(rankResultEntry.getKey(), rankResultEntry.getValue());
        }
        return totalReward;
    }

    private long calculateReward(final Rank rank, final int count) {
        return rank.totalReward(rank, count);
    }

    public LottoNumbersDto getLottoNumbersDto() {
        return new LottoNumbersDto(convertToNumbersList());
    }

    private List<List<Integer>> convertToNumbersList() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

}
