package lotto;

import java.util.Arrays;
import java.util.EnumMap;

public class Result {

    private EnumMap<Ranking, Integer> result;

    public Result() {
        this.result = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(ranking -> result.put(ranking, 0));
    }

    public void put(Ranking ranking) {
        result.put(ranking, result.get(ranking) + 1);
    }

    public EnumMap<Ranking, Integer> getResult() {
        return result;
    }

    private int getTotalReward() {
        return result.entrySet().stream().mapToInt(entry -> entry.getKey().getReward() * entry.getValue()).sum();
    }

    public double calculateRateOfReturn() {
        int lottoPurchaseMoney = result.entrySet().stream().mapToInt(entry -> entry.getValue()).sum() * 1000;
        return getTotalReward() / (double) lottoPurchaseMoney;
    }

}
