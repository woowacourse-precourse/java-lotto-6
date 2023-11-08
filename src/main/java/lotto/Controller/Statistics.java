package lotto.Controller;

import static lotto.Constants.COUNT_MIN;
import static lotto.MatchNums.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.MatchNums;
import lotto.Model.Lotto;
import lotto.View.OutputView;

public class Statistics {
    private HashMap<Integer, Integer> countMap = new HashMap<>();

    public Statistics(){
        Arrays.stream(MatchNums.values()).forEach(o->countMap.put(o.getNum(), 0));
    }

    public void updateResult(Calculate calculate, List<Lotto> lottos, List<Integer> winningNums, int bonus){
        for (Lotto nums: lottos){
            if (calculate.canBeBonus(nums.getNumbers(), winningNums, bonus)){
                countMap.put(FIVE_AND_BONUS.getNum(), countMap.get(FIVE_AND_BONUS.getNum())+1);
                continue;
            }
            int cnt = calculate.getMatchCount(nums.getNumbers(), winningNums);
            if (cnt >= COUNT_MIN.getNum()){
                countMap.put(cnt, countMap.get(cnt)+1);
            }
        }
    }

    public void printStatistics(OutputView outputView){
        Arrays.stream(MatchNums.values()).forEach(o-> {
            outputView.printStatistics(o.getPrintComment(), countMap.get(o.getNum()));
        });

    }

    public void printProfit(OutputView outputView, Calculate calculate, int cost){
        int profit = calculate.getProfitCost(countMap);
        String profitRate = calculate.getProfitRate(profit, cost);
        outputView.printProfit(profitRate);
    }

}
