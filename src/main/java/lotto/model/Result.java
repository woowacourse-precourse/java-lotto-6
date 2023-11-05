package lotto.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.StringJoiner;

public class Result {
    private final HashMap<Rank,Integer> result;

    public Result(HashMap<Rank, Integer> result) {
        this.result = result;
    }

    public double calculateProfitRate(int amount){
        double totalProfit = result.entrySet().stream()
                .mapToDouble(r -> r.getKey().getPrize()*r.getValue())
                .sum();
        return (totalProfit / (amount * 1000)) * 100;
    }
    @Override
    public String toString(){
        StringJoiner output = new StringJoiner("\n");
        result.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(Rank.NONE))
                .sorted(Comparator.comparingLong(o -> o.getKey().getPrize()))
                .forEach(
                        entry -> output.add(entry.getKey() + " - " + entry.getValue() + "개"));
        return output.toString();
    }
}
