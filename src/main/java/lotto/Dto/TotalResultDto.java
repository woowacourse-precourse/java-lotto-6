package lotto.Dto;

import java.util.ArrayList;
import java.util.List;

public class TotalResultDto {
    // [match, prize, won]
    List<SingleResultDto> results = new ArrayList<>();
    double profit;
    int size;

    public void add(SingleResultDto singleResultDto) {
        this.results.add(singleResultDto);
    }

    public int size() {
        return this.results.size();
    }

    public SingleResultDto get(int index) {
        return results.get(index);
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return this.profit;
    }
}
