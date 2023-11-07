package lotto.model;

import lotto.config.Rank;
import lotto.util.Validator;

import java.util.Map;

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
}
