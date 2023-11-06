package lotto.Dto;

import java.util.ArrayList;
import java.util.List;

public class LottoResultDto {
    List<List<Integer>> result = new ArrayList<>();
    double profit;

    public void setResult(List<List<Integer>> result) {
        this.result = result;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public List<List<Integer>> getResult() {
        return result;
    }

    public double getProfit() {
        return profit;
    }


}
