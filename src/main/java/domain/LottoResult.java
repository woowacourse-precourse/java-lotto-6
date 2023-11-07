package domain;

import util.ConstOfLottoResult;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Long profit;
    private Map<Integer, Integer> result = new HashMap<>(); // key: 등 수, value: 개수

    public LottoResult() {
        result.put(0,0); //0등은 존재 X, 1~5등 이외의 결과를 저장하는 공간
        result.put(1,0);
        result.put(2,0);
        result.put(3,0);
        result.put(4,0);
        result.put(5,0);
        profit = 0L;
    }

    public void increaseCountOfRank(int rank) {
        result.put(rank,result.get(rank)+1);
    }

    public int getCountOfRank(int rank) {
        return result.get(rank);
    }

    public Long getProfit() {
        return profit;
    }

    private void calculateTotalProfit() {
        for(ConstOfLottoResult constOfLottoResult : ConstOfLottoResult.values()) {
            int price = constOfLottoResult.getPrice();
            profit += (price * result.get(constOfLottoResult.getRank()));
        }
    }

    public double calculateRateOfProfit(int money) {
        calculateTotalProfit();
        return (double) profit / (double) money * 100.0;
    }

}
