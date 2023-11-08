package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class WinningLottoTable {

    private final Map<Rank, Integer> rankTable;

    public WinningLottoTable(Map<Rank, Integer> rankTable) {
        this.rankTable = rankTable;
    }

    public double calculateTotalWinnings() {
        return rankTable.entrySet().stream().filter(this::winnable).mapToDouble(this::calculateRankPrice).sum();
    }

    private boolean winnable(Entry<Rank, Integer> rankTable) {
        return rankTable.getValue() != 0;
    }

    private double calculateRankPrice(Entry<Rank, Integer> rankTable) {
        return rankTable.getKey().getLotteryWinnings() * rankTable.getValue();
    }

    public Map<Rank, Integer> getRankTable() {
        return rankTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLottoTable that = (WinningLottoTable) o;
        return Objects.equals(rankTable, that.rankTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankTable);
    }
}
