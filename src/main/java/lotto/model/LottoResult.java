package lotto.model;

import static lotto.Constants.Constants.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private static final double PERCENT = 100.0;

    private final Map<LottoRank, Integer> result;

    public LottoResult(List<LottoRank> ranks) {
        this.result = createLottoResultMap(ranks);
    }

    private Map<LottoRank, Integer> createLottoResultMap(List<LottoRank> ranks) {
        return Arrays.stream(LottoRank.values())
            .collect(Collectors.toMap(rank -> rank, rank -> countRank(ranks, rank)));
    }

    private Integer countRank(List<LottoRank> ranks, LottoRank target) {
        return (int) ranks.stream()
            .filter(rank -> rank == target)
            .count();
    }

    public List<String> toOutputStrings() {
        return Arrays.stream(LottoRank.values())
            .filter(LottoRank::isPositivePrize)
            .map(this::getLottoRankOutputString)
            .toList();
    }

    private String getLottoRankOutputString(final LottoRank lottoRank) {
        return lottoRank.getOutputString(result.get(lottoRank));
    }

    public double getEarningsRate() {
        return getWinningAmount() * PERCENT / (countLottos() * LOTTO_PRICE);
    }

    private int getWinningAmount() {
        return Arrays.stream(LottoRank.values())
            .mapToInt(rank -> rank.getPrize() * result.get(rank))
            .sum();
    }

    private int countLottos() {
        return result.values()
            .stream()
            .mapToInt(num -> num)
            .sum();
    }

}