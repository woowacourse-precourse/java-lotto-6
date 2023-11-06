package lotto;

import java.util.HashMap;

public class Monitor {
    public void displayBoughtLottoEnvelope(LottoEnvelope lottoEnvelope) {
        System.out.println(lottoEnvelope.getLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottoEnvelope.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayStatistics(HashMap<Integer, Integer> statistics) {
    }

    public void displayEarningRate(Float earningRate) {
    }
}
