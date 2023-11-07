package lotto.Dto;

import java.util.HashMap;
import java.util.Map;

public class TotalResultDto {
    // [match, bonus, prize, won]
    Map<Integer, SingleResultDto> results = new HashMap<>();
    double profit;
    int size;

    public void add(Integer a, SingleResultDto result) {
        this.results.put(a, result);
    }

    public int size() {
        return this.size();
    }

    public SingleResultDto getSingleResult(int x) {
        return results.get(x);
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return this.profit;
    }


}
