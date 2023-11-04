package lotto.domain;

import java.math.BigDecimal;
import lotto.dto.LottoNumbersInfo;
import lotto.dto.LottoPurchaseInfo;

public class LottoLogic {
    private LottoPurchaseInfo purchaseInfo;
    private LottoNumbersInfo lottoNumbersInfo;


    public LottoLogic(LottoPurchaseInfo purchaseInfo, LottoNumbersInfo lottoNumbersInfo) {
        this.purchaseInfo = purchaseInfo;
        this.lottoNumbersInfo = lottoNumbersInfo;
    }


    public BigDecimal getNumberOfLottoPurchased() {
        return purchaseInfo.numberOfLottoPurchased;
    }
}
