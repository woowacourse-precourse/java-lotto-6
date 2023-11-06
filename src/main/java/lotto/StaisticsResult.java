package lotto;

import java.util.HashMap;
import java.util.List;

public class StaisticsResult {
    private HashMap<Integer, Integer> countMap = new HashMap<>();

    public StaisticsResult(){
        countMap.put(3, 0);
        countMap.put(4, 0);
        countMap.put(5, 0);
        countMap.put(55, 0);
        countMap.put(6, 0);
    }

    public void updateResult(CalculateLotto calculateLotto, List<Lotto> lottos, List<Integer> winningNums, int bonus){
        for (Lotto nums: lottos){
            if (calculateLotto.checkBonus(nums.getNumbers(), winningNums, bonus)){
                countMap.put(55, countMap.get(55)+1);
                continue;
            }
            int cnt = calculateLotto.checkMatch(nums.getNumbers(), winningNums);
            if (cnt > 2){
                countMap.put(cnt, countMap.get(cnt)+1);
            }
        }
    }

    public void printStatistics(OutputView outputView, CalculateLotto calculateLotto, int cost){
        outputView.print3Matchs(countMap.get(3));
        outputView.print4Matchs(countMap.get(4));
        outputView.print5Matchs(countMap.get(5));
        outputView.print5MatchsWithBonus(countMap.get(55));
        outputView.print6Matchs(countMap.get(6));
        int profit = calculateLotto.getProfit(countMap);
        double profitRate = calculateLotto.roi(profit, cost);
        outputView.printProfit(profitRate);
    }

}
