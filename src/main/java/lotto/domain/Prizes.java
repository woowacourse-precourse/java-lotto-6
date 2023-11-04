package lotto.domain;

import org.mockito.junit.MockitoTestRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prizes {
    private final Map<Prize, Integer> prizes;

    public Prizes(List<Prize> prizeDummy) {
        this.prizes = new HashMap<>();
        initPrizes();
        updatePrizeDummy(prizeDummy);
    }

    private void initPrizes() {
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
    }

    private void updatePrizeDummy(List<Prize> prizeDummy) {
        for (Prize prize : prizeDummy) {
            prizes.put(prize, prizes.get(prize)+1);
        }
    }

    public Integer countPrize(Prize prize) {
        return prizes.get(prize);
    }


    public Double countTotalPrice() {
        Double totalPrice = 0.0;
        for (Prize prize : prizes.keySet()) {
            Integer count = prizes.get(prize);
            totalPrice += prize.getReward() * count;
        }

        return totalPrice;
    }

    public Double calculateBenefit(Integer totalSeed) {
        Double totalReward = countTotalPrice();
        if (totalReward == 0) {
            return 0.0;
        }

        Double benefit = (totalReward / totalSeed) * 100.0;
        return Math.round(benefit * 100) / 100.0;


    }

}
