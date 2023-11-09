package lotto.domain.statistics;

import lotto.domain.dto.WinningStatisticsDto;
import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private final Map<LottoRank, Integer> winningsStatistics;
    private final Money money;

    public WinningStatistics(Money money) {
        winningsStatistics = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(rank -> winningsStatistics.put(rank,0));
        this.money = money;
    }

    public void updateStatistics(List<LottoResult> lottoResults) {
        lottoResults.stream()
                .filter(result -> result.getRank() != null)
                .forEach(result -> addCount(result.getRank()));
    }

    public int getCountOfRank(LottoRank rank) {
        return winningsStatistics.get(rank);
    }

    public long getPrizeMoney() {
        return Arrays.stream(LottoRank.values())
                .mapToLong(rank -> getCountOfRank(rank)* (long)rank.getPrize())
                .sum();
    }

    public WinningStatisticsDto mapToDto() {
        return new WinningStatisticsDto(
                getCountOfRank(LottoRank.FIFTH_PLACE),
                getCountOfRank(LottoRank.FOURTH_PLACE),
                getCountOfRank(LottoRank.THIRD_PLACE),
                getCountOfRank(LottoRank.SECOND_PLACE),
                getCountOfRank(LottoRank.FIRST_PLACE),
                money.getRateOfReturn(getPrizeMoney())
        );
    }

    private void addCount(LottoRank rank) {
        int exist = winningsStatistics.get(rank);
        winningsStatistics.put(rank,++exist);
    }

}
