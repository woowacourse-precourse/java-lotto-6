package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class Result {
    private final LinkedHashMap<Statistics, Integer> result = new LinkedHashMap<>();

    private Result(final List<Lotto> lottos, final WinnigNumber winnigNumber) {
        validate(lottos);
        for (Lotto lotto : lottos) {
            Statistics statistics = Statistics.of(lotto.countMatchNumber(winnigNumber),
                    lotto.contains(winnigNumber.getBonus()));
            add(statistics);
        }
    }

    public static Result of(final List<Lotto> lottos, final WinnigNumber winnigNumber) {
        return new Result(lottos, winnigNumber);
    }

    private void validate(final List<Lotto> lottos) {
        if (lottos.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getRankCount(final Statistics statistics) {
        return result.getOrDefault(statistics, 0);
    }

    private void add(final Statistics statistics) {
        result.put(statistics, result.getOrDefault(statistics, 0) + 1);
    }
}
