package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.dto.LottoNumbersInfo;
import lotto.dto.LottoPurchaseInfo;
import lotto.message.LottoResult;

public class LottoLogic {
    private LottoPurchaseInfo purchaseInfo;
    private LottoNumbersInfo lottoNumbersInfo;
    private List<Integer> winningNumbers;


    public LottoLogic(LottoPurchaseInfo purchaseInfo, LottoNumbersInfo lottoNumbersInfo, List<Integer> winningNumbers) {
        this.purchaseInfo = purchaseInfo;
        this.lottoNumbersInfo = lottoNumbersInfo;
        this.winningNumbers = winningNumbers;
    }

    public HashMap<LottoResult, BigDecimal> getResult() {
        return lottoNumbersInfo.getResult(winningNumbers);
    }

    public BigDecimal getNumberOfLottoPurchased() {
        return purchaseInfo.numberOfLottoPurchased;
    }

    public float getProfitRate() {
        HashMap<LottoResult, BigDecimal> result = getResult();

        BigDecimal total = BigDecimal.ZERO;
        for (LottoResult key : result.keySet()) {
            BigDecimal prize = BigDecimal.valueOf(key.getPrize());
            total = total.add(result.get(key).multiply(prize));
        }

        return total.divide(purchaseInfo.purchaseAmount).floatValue();
    }
}
