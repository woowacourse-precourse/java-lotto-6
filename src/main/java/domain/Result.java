package domain;


import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.StringJoiner;

public class Result {
    private static Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public Result(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static double calculateEarningsRate(long payment) {
        double totalPrize = calculatePrize();
        return totalPrize / payment * 100;
    }

    public static double calculatePrize() {
        return result.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().multiple(entry.getValue()))
                .sum();
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner("\n");
        result.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(Rank.MISS))
                .sorted(Comparator.comparingLong(o -> o.getKey().getPrize()))
                .forEach(
                        entry -> output.add(entry.getKey() + " - " + entry.getValue() + "개"));
        return output.toString();
    }

}
