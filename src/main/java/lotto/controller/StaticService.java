package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Statistic;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class StaticService {
    private List<Statistic> statistics = new ArrayList<>();
    private double rate;

    public StaticService() {
        makeStatistics();
    }

    public void makeStatistics() {
        Rank[] values = Rank.values();
        for(Rank rank : values) {
            statistics.add(new Statistic(rank));
        }
    }

    public void setStatics(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        for(Lotto lotto : lottos) {
            Statistic statistic = compareLottoNumber(lotto.getNumbers(), winningLotto.getNumbers(), bonusNumber);
            statistic.increaseCount();
        }
    }

    private Statistic compareLottoNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        Boolean bonusMatch = false;

        for(int number : lottoNumbers) {
            if(winningNumbers.contains(number)) {
                matchCount++;
            }
            if(number == bonusNumber) {
                bonusMatch = true;
            }
        }

        return getStatistic(matchCount, bonusMatch);
    }

    private Statistic getStatistic(int matchCount, Boolean bonusMatch) {
        if (matchCount >= 6) {
            return statistics.get(0);
        } else if (matchCount >=5 && bonusMatch) {
            return statistics.get(1);
        } else if (matchCount >= 5) {
            return statistics.get(2);
        } else if (matchCount >= 4) {
            return statistics.get(3);
        } else if (matchCount >= 3) {
            return statistics.get(4);
        }
        return statistics.get(5);
    }

    public void outputStatistics() {
        for(int i = 4; i >= 0; i--){
            Statistic statistic = statistics.get(i);
            OutputView.outputStatistic(statistic.getRank().getDescription(), statistic.getRank().getPrize(), statistic.getCount());
        }
    }

    public void makeRate(int purchaseAmount) {
        double sum = calculatorPrizeSum();
        this.rate = sum / purchaseAmount * 100 ;
    }

    public void outputRate() {
        OutputView.outputRate(rate);
    }

    private double calculatorPrizeSum() {
        int sum = 0;
        for(int i = 4; i >= 0; i--){
            Statistic statistic = statistics.get(i);
            sum += statistic.getRank().getReward() * statistic.getCount();
        }
        return sum;
    }
}
