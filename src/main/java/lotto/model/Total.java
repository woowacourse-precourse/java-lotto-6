package lotto.model;

import java.util.List;

public class Total {

    public Total(List<Prize> totalPrize) {
        calculateTotalPrize(totalPrize);
    }

    private void calculateTotalPrize(List<Prize> totalPrize) {
        totalPrize.forEach(prize -> prize.increaseCount(prize));
    }

}
