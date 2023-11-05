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

    public float getRateOfReturn() {
        HashMap<LottoResult, BigDecimal> result = getResult();
        BigDecimal total = BigDecimal.ZERO;
        result.forEach((key, value) -> {
            BigDecimal prize = new BigDecimal(key.getPrize());
            total.add(prize.multiply(value));
        });
        return total.divide(purchaseInfo.purchaseAmount).floatValue();
    }
}
