package lotto.model;

import java.util.HashMap;

public class Result {
    private final HashMap<Rank,Integer> result;

    public Result(HashMap<Rank, Integer> result) {
        this.result = result;
    }

    public double calculateProfitRate(int amount){
        double totalProfit = result.entrySet().stream()
                .mapToDouble(r -> r.getKey().getPrize()*r.getValue())
                .sum();
        System.out.println("수익룰" + totalProfit);
        System.out.println("구매" + amount);
        return (totalProfit / (amount * 1000)) * 100;
    }
}
