package lotto.domain;

import lotto.domain.strategy.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    //TODO: 여기서 사용하고 있는 WinningNumbers를 List<Integer> 타입으로 받아올 수 있게 바꾸는 메서드도 작성해야 됨 ;;

    private Map<WinningStatistics, Integer> totalStatistics;
    private List<WinningStrategy> strategies;

    public void initializeTotalStatistics(){
        if (totalStatistics==null){
            this.totalStatistics = new Hashtable<>();
        }
        for (WinningStatistics winningStatistics : WinningStatistics.values()) {
            this.totalStatistics.put(winningStatistics, 0);
        }

    }

    public LottoResultCalculator() {
        this.totalStatistics = new Hashtable<>();
        this.strategies = new ArrayList<>();
        this.initializeStrategies();
        this.initializeTotalStatistics();
    }

    private void initializeStrategies() {
        strategies.add(new ThreeMatchedWinningStrategy());
        strategies.add(new FourMatchedWinningStrategy());
        strategies.add(new FiveMatchedWinningStrategy());
        strategies.add(new FiveBonusMatchedWinningStrategy());
        strategies.add(new SixMatchedWinningStrategy());
    }


    public void lottoWinningCountingCalculate(List<Integer> winningNumbers,
                                              List<Integer> lottoTicket,
                                              int bonusNumber, LottoGameCalculator lottoGameCalculator){

        int countMatchedNumbers = lottoGameCalculator.countMatchedNumbers(winningNumbers, lottoTicket);
        int index = countMatchedNumbers - 3;
        if (countMatchedNumbers == 3) {
            strategies.get(index).apply(totalStatistics);
        } else if (countMatchedNumbers == 4){
            strategies.get(index).apply(totalStatistics);
        } else if (countMatchedNumbers == 5 && !lottoGameCalculator.isMatchedBonusNumber(winningNumbers, bonusNumber)){
            strategies.get(index).apply(totalStatistics);
        } else if (countMatchedNumbers == 5 && lottoGameCalculator.isMatchedBonusNumber(winningNumbers, bonusNumber)){
            index+=1;
            strategies.get(index).apply(totalStatistics);
        } else if (countMatchedNumbers == 6){
            strategies.get(index).apply(totalStatistics);
        }
    }

    public Map<WinningStatistics, Integer> getTotalStatistics(){
        return this.totalStatistics;
    }

    public double lottoPrizeRateCalculate(int purchasePrice,
                                        Map<WinningStatistics, Integer> totalStatistics){

        long totalPrice = 0;
        double result = 0;

        totalPrice = getTotalPrice(totalStatistics, totalPrice);

        result = (double)((totalPrice * 100) / (double) purchasePrice);

        return result;

    }

    private static long getTotalPrice(Map<WinningStatistics, Integer> totalStatistics, long totalPrice) {
        for (Map.Entry<WinningStatistics, Integer> winningStatisticsIntegerEntry : totalStatistics.entrySet()) {
            WinningStatistics key = winningStatisticsIntegerEntry.getKey();
            int numberOfWins = winningStatisticsIntegerEntry.getValue();
            totalPrice += key.getWinningPrize()*numberOfWins;
        }
        return totalPrice;
    }


}
