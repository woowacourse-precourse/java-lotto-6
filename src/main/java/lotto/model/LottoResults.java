package lotto.model;

import lotto.config.Rank;
import lotto.util.Validator;

import java.util.Map;
import java.util.Objects;

public class LottoResults {

    private final Map<Rank, Long> results;

    private LottoResults(Map<Rank, Long> results) {
        this.results = Map.copyOf(results);
    }

    public static LottoResults from(Map<Rank, Long> results) {
        Validator.validateNotNull(results);
        return new LottoResults(results);
    }

    public Map<Rank, Long> getResults() {
        return results;
    }

    public long calculateTotalPrize() {
        return results.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.NONE)
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
