package lotto.model;

import java.util.Comparator;
import java.util.Map;
import java.util.StringJoiner;

public class Result {

    private final Map<Ranking, Integer> result;

    public Result(Map<Ranking, Integer> result) {
        this.result = result;
    }

    public double rateOfReturn() {
        double total = totalPrize();
        long purchase = Purchase();
        return total / purchase * 100;
    }


    private double totalPrize() {
        return result.entrySet().stream().mapToLong(entry -> entry.getKey().getPrize() * entry.getValue()).sum();
    }

    private long Purchase() {
        long count = result.values()
                .stream()
                .mapToLong(i -> i)
                .sum();
        return count * 1000;
    }


    @Override
    public String toString() {
        StringJoiner output = new StringJoiner("\n");
        result.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(Ranking.MISS))
                .sorted(Comparator.comparingLong(o -> o.getKey().getPrize()))
                .forEach(
                        entry -> output.add(entry.getKey() + " - " + entry.getValue() + "개"));
        return output.toString();
    }
}
