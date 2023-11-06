package lotto.domain;

import static lotto.constants.Value.INITIAL_ZERO;
import static lotto.constants.Value.LOTTO_PRICE;
import static lotto.constants.Value.PERCENT;

import java.util.HashMap;
import java.util.Map;
import lotto.constants.Prize;

public class LottoResult {

    public Map<Prize, Integer> state;

    public LottoResult() {
        state = new HashMap<>();
        initializePrize();
    }

    private void initializePrize() {
        for (Prize prize : Prize.values()) {
            state.put(prize, INITIAL_ZERO.get());
        }
    }

    public Double calculateEarningsRate(Integer lottoCount) {
        int sum = INITIAL_ZERO.get();

        for (Prize key : state.keySet()) {
            sum += (key.getPrizeAmount() * state.get(key));
        }

        return ((double) sum / (lottoCount * LOTTO_PRICE.get())) * PERCENT.get();
    }


}
