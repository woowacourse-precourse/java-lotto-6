package lotto.domain;

import static lotto.constants.Value.LOTTO_PRICE;
import static lotto.constants.Value.PERCENT;

import java.util.Map;
import lotto.constants.Prize;

public class LottoResult {

    public Map<Prize, Integer> state;

    public LottoResult() {
        initializePrize();
    }

    private void initializePrize() {
        for (Prize prize : Prize.values()) {
            state.put(prize, 0);
        }
    }

    public Double calculateEarningsRate(Integer lottoCount) {
        int sum = 0;

        for (Prize key : state.keySet()) {
            sum += key.getPrizeAmount() * state.get(key);
        }

        return ((double) sum / (lottoCount * LOTTO_PRICE.get())) * PERCENT.get();
    }


}
