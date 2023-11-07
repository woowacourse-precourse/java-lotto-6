package lotto.Dto;

import java.util.ArrayList;
import java.util.List;

public class TotalResultDto {
    // [match, bonus, prize, won]
    List<SingleResultDto> results = new ArrayList<>();
    double profit;
    int size;

    public void add(Integer code, SingleResultDto singleResultDto) {
        this.results.add(singleResultDto);
    }

    public int size() {
        return this.results.size();
    }

    public SingleResultDto get(int x) {
        return results.get(x);
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return this.profit;
    }
}
