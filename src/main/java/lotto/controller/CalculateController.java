package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rankings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
- [ ] 당첨 여부와 등수를 계산하는 기능
- [ ] 수익률을 계산 하는 기능
* JAVA ENUM 기능 사용해서 작성
 */
/*
- 당첨 번호가 로또 번호에 몇 개 있는지 contains로 비교, 6개 -> FIRST, 5개 -> 보너스 비교 -> 5+보너스 -> SECOND, 아니면 THIRD, 4개 -> FOURTH,
3개 -> FIFTH.
 */
public class CalculateController {
    private final double RATE_VALUE = 100;
    Lotto lottos;
    List<Integer> prizeNumbers;
    int bonusNumber;
    int lottoPrices;
    int[] results = new int[LottoController.LOTTO_COUNTS];
    double profitRates;


    public CalculateController(Lotto lottos, List<Integer> prizeNumbers, int bonusNumber,int lottoPrices) {
        this.lottos = lottos;
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoPrices = lottoPrices;
    }

    public int whatOfRanking() {
        int rankings = 0;
        for (int findNumber :
                prizeNumbers) {
            if (lottos.getNumbers().contains(findNumber)) {
                rankings++;
            }
        }
        if(lottos.getNumbers().contains(bonusNumber)) {
            rankings = Rankings.RankingData.SECOND.getValues();
        }
        return rankings;
    }
    public void calculateResults() {
        results[Rankings.RankingData.returnRank(whatOfRanking()).getValues()]++;
    }
    public double calculateRate() {
        double sum = Arrays.stream(results).sum();
        return (sum / lottoPrices) * RATE_VALUE;
    }
    void run() {
        for (int i = 0; i < lottoPrices / 1000; i++) {
            calculateResults();
        }
        profitRates = calculateRate();
    }

}
