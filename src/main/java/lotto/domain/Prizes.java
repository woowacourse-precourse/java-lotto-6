package lotto.domain;

import lotto.constant.PrizesConstant;
import org.mockito.junit.MockitoTestRule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.constant.PrizesConstant.*;

public class Prizes {

    private static final Integer INIT_PRIZE_COUNT = 0;
    private final Map<Prize, Integer> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = new HashMap<>();
        initPrizes();
        updatePrizes(prizes);
    }

    private void initPrizes() {
        for (Prize prize : Prize.values()) {
            prizes.put(prize, INIT_PRIZE_COUNT);
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
        Double totalReward = INIT_REWARD.getSetting();
        for (Prize prize : prizes.keySet()) {
            Integer currentCount = prizes.get(prize);
            totalReward += prize.getReward() * currentCount;
        }

        return totalReward;
    }

    public Double getTotalBenefit(Integer totalSpendAmount) {
        Double totalReward = getTotalReward();
        if (totalReward == INIT_REWARD.getSetting()) {
            return NO_BENEFIT.getSetting();
        }

        Double totalBenefit = (totalReward / totalSpendAmount) * PERCENTAGE_INDICATOR.getSetting();
        return Math.round(totalBenefit * ROUND_INDICATOR.getSetting()) / ROUND_INDICATOR.getSetting();
    }

}
