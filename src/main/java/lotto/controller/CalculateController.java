package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rankings;

import java.util.List;

public class CalculateController {
    private final double RATE_VALUE = 100;
    List<Lotto> lottos;
    List<Integer> prizeNumbers;
    int bonusNumber;
    int lottoPrices;
    int[] results = new int[LottoController.LOTTO_COUNTS];
    double profitRates;


    public CalculateController(List<Lotto> lottos, List<Integer> prizeNumbers, int bonusNumber,int lottoPrices) {
        this.lottos = lottos;
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoPrices = lottoPrices;
    }

    public int[] getResults() {
        return results;
    }
    public int whatOfRanking(Lotto lotto) {
        int rankings = 0;
        for (int findNumber :
                prizeNumbers) {
            if (lotto.getNumbers().contains(findNumber)) {
                rankings++;
            }
        } 
        if(rankings == Rankings.RankingData.THIRD.getValues() && lotto.getNumbers().contains(bonusNumber)) {
            rankings = Rankings.RankingData.SECOND.getValues();
        }
        return rankings;
    }
    public void calculateResults(Lotto lotto) {
        Rankings.RankingData result = Rankings.RankingData.returnRank(whatOfRanking(lotto));
        if(result != null && result.getValues() > 2) {
            results[result.getValues()]++;
        }
    }
    public double calculateRate() {
        double sum = 0;
        for (Rankings.RankingData rankingData:
             Rankings.RankingData.values()) {
            sum += (results[rankingData.getValues()] * rankingData.getPrizes());
        }
        return (sum / lottoPrices) * RATE_VALUE;
    }
    public void run() {
        for (Lotto lotto:
             lottos) {
            calculateResults(lotto);
        }
        profitRates = calculateRate();
    }

}
