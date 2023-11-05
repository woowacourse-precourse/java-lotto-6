package lotto.domain;

import java.util.Map;
import lotto.Prize;

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

    public Double calculateEarningRate(Integer lottoCount) {
        int sum = 0;

        for (Prize key : state.keySet()) {
            sum += key.getPrizeAmount() * state.get(key);
        }

        return ((double) sum / (lottoCount * 1000)) * 100;
    }


}
