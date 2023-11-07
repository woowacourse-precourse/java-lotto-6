package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import lotto.message.LottoResult;

public class LottoPurchase {
    private final BigDecimal purchaseAmount;
    private LottoNumbersInfo lottoNumbersInfo;


    public LottoPurchase(BigDecimal purchaseAmount, LottoNumbersInfo lottoNumbersInfo) {
        this.purchaseAmount = purchaseAmount;
        this.lottoNumbersInfo = lottoNumbersInfo;
    }

    public HashMap<LottoResult, BigDecimal> getResult() {
        return lottoNumbersInfo.getResult();
    }

    public float getProfitRate() {
        HashMap<LottoResult, BigDecimal> result = getResult();

        BigDecimal total = BigDecimal.ZERO;
        for (LottoResult key : result.keySet()) {
            BigDecimal prize = BigDecimal.valueOf(key.getPrize());
            total = total.add(result.get(key).multiply(prize));
        }

        return total.divide(purchaseAmount).floatValue() * 100;
    }
}
