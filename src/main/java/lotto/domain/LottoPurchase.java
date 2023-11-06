package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import lotto.dto.LottoNumbersInfo;
import lotto.dto.LottoPurchaseInfo;
import lotto.message.LottoResult;

public class LottoPurchase {
    private LottoPurchaseInfo purchaseInfo;
    private LottoNumbersInfo lottoNumbersInfo;


    public LottoPurchase(LottoPurchaseInfo purchaseInfo, LottoNumbersInfo lottoNumbersInfo) {
        this.purchaseInfo = purchaseInfo;
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

        return total.divide(purchaseInfo.getPurchaseAmount()).floatValue();
    }
}
