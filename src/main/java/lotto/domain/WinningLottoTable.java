package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class WinningLottoTable {

    private final Map<Rank, Integer> rankTable;

    public WinningLottoTable(Map<Rank, Integer> rankTable) {
        this.rankTable = rankTable;
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
