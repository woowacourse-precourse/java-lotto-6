package lotto.Model;

import static lotto.MatchNums.*;

import java.util.HashMap;
import java.util.List;
import lotto.Controller.CalculateLotto;
import lotto.View.OutputView;

public class StaisticsResult {
    private static final int COUNT_MIN = 3;
    private HashMap<Integer, Integer> countMap = new HashMap<>();

    public StaisticsResult(){
        countMap.put(THREE.getNum(), 0);
        countMap.put(FOUR.getNum(), 0);
        countMap.put(FIVE.getNum(), 0);
        countMap.put(FIVE_AND_BONUS.getNum(), 0);
        countMap.put(SIX.getNum(), 0);
    }

    public void updateResult(CalculateLotto calculateLotto, List<Lotto> lottos, List<Integer> winningNums, int bonus){
        for (Lotto nums: lottos){
            if (calculateLotto.checkBonus(nums.getNumbers(), winningNums, bonus)){
                countMap.put(FIVE_AND_BONUS.getNum(), countMap.get(FIVE_AND_BONUS.getNum())+1);
                continue;
            }
            int cnt = calculateLotto.checkMatch(nums.getNumbers(), winningNums);
            if (cnt >= COUNT_MIN){
                countMap.put(cnt, countMap.get(cnt)+1);
            }
        }
    }

    public void printStatistics(OutputView outputView, CalculateLotto calculateLotto, int cost){
        outputView.print3Matchs(countMap.get(THREE.getNum()));
        outputView.print4Matchs(countMap.get(FOUR.getNum()));
        outputView.print5Matchs(countMap.get(FIVE.getNum()));
        outputView.print5MatchsWithBonus(countMap.get(FIVE_AND_BONUS.getNum()));
        outputView.print6Matchs(countMap.get(SIX.getNum()));
        int profit = calculateLotto.getProfit(countMap);
        double profitRate = calculateLotto.roi(profit, cost);
        outputView.printProfit(profitRate);
    }

}
