package lotto.domain;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import lotto.CustomLotteryRanking;


public class LotteryResults {
    private static final int MAX_MATCHES = Integer.MAX_VALUE/2;
    private final Map<LotteryRanking, Integer> results;
    private final Collection<? extends  LotteryRanking> rankings;

    private LotteryResults(Collection<? extends  LotteryRanking> rankings) {
        this.rankings = Objects.requireNonNull(rankings);
        this.results = createEmptyLotteryRankingMap();
    }

    public LotteryResults(LotteryRanking ranking, int matches, Collection<? extends LotteryRanking> rankings) {
        this(rankings);
        validateMatches(matches);
        apply(ranking, matches);
    }

    public static LotteryResults emptyResults(Collection<? extends LotteryRanking> rankings) {
        return new LotteryResults(rankings);
    }

    private static void validateMatches(int matches){
        if(matches < 0 || matches > MAX_MATCHES){
            throw new IllegalArgumentException();
        }
    }

    private void apply(LotteryRanking ranking, int matches) {
        validateMatches(matches);
        int oldValue = results.getOrDefault(ranking, 0);
        validateMatches(oldValue+matches);
        results.put(ranking, oldValue + matches);
    }

    public LotteryResults applyResults(LotteryResults others) {
        for (LotteryRanking ranking : others.results.keySet()) {
            apply(ranking, others.results.get(ranking));
        }
        return this;
    }

    public long getTotalAmount() {
        return results.entrySet()
                .stream()
                .mapToLong(entry -> calculateAmount(entry))
                .sum();
    }

    public List<LotteryResult> toList() {
        return results.entrySet()
                .stream()
                .map(entry -> new LotteryResult(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private long calculateAmount(Map.Entry<LotteryRanking, Integer> entry) {
        return entry.getKey().getAmount() * entry.getValue();
    }

    private Map<LotteryRanking, Integer> createEmptyLotteryRankingMap() {
        Map<LotteryRanking, Integer> result = new TreeMap<>();
        for (LotteryRanking ranking : rankings) {
            result.put(ranking, 0);
        }
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        LotteryResults other = (LotteryResults) obj;

        return results.equals(other.results);
    }

    @Override
    public int hashCode() {
        return results.hashCode();
    }
}
