package lotto.model;

import lotto.entity.Prize;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public class Profit {
    private final Map<Prize, Integer> resultCount;
    private Integer amount = 0;
    private Integer profit = 0;

    public Profit() {
        this.resultCount = init();
    }

    public double getProfitRate() {
        return (double) profit / amount*100;
    }

    public void updateProfitRate(Prize prize) {
        this.amount += 1000;
        this.profit += prize.getReward();
        resultCount.put(prize,resultCount.get(prize)+1);
    }

    public Map<Prize, Integer> init() {
        Map<Prize, Integer> result = new EnumMap<>(Prize.class);
        Stream<Prize> stream = Arrays.stream(Prize.values());
        stream.forEach(prize -> result.put(prize, 0));
        return result;
    }
    public Map<Prize,Integer> getResultCount(){
        return resultCount;
    }
}
