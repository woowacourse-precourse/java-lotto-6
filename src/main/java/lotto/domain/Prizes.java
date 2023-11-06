package lotto.domain;

import org.mockito.junit.MockitoTestRule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prizes {

    private final Map<Prize, Integer> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = new HashMap<>();
        initPrizes();
        updatePrizes(prizes);
    }

    private void initPrizes() {
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
    }

    private void updatePrizes(List<Prize> prizes) {
        for (Prize prize : prizes) {
            Integer currentCount = this.prizes.get(prize);
            this.prizes.put(prize, currentCount++);
        }
    }

    public Integer countPrize(Prize prize) {
        return prizes.get(prize);
    }


    private Double getTotalReward() {
        Double totalReward = 0.0;
        for (Prize prize : prizes.keySet()) {
            Integer currentCount = prizes.get(prize);
            totalReward += prize.getReward() * currentCount;
        }

        return totalReward;
    }

    public Double getTotalBenefit(Integer totalSpendAmount) {
        Double totalReward = getTotalReward();
        if (totalReward == 0.0) {
            return 0.0;
        }

        Double totalBenefit = (totalReward / totalSpendAmount) * 100.0;
        return Math.round(totalBenefit * 100.0) / 100.0;
    }

}
