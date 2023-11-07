package lotto.dto;

import lotto.domain.Rank;

import java.util.Map;
import java.util.Objects;

public class WinningResult {

    private final Map<Rank, Integer> ranks;

    public WinningResult(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResult winningResult = (WinningResult) o;
        return Objects.equals(ranks, winningResult.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
