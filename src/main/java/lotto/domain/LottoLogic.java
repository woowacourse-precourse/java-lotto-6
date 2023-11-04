package lotto.domain;

import static lotto.message.ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.dto.LottoNumbersInfo;
import lotto.dto.LottoPurchaseInfo;
import lotto.utils.LottoUtil;

public class LottoLogic {
    private LottoPurchaseInfo purchaseInfo;
    private LottoNumbersInfo lottoNumbersInfo;


    public LottoLogic(LottoPurchaseInfo purchaseInfo, LottoNumbersInfo lottoNumbersInfo) {


        this.purchaseInfo = purchaseInfo;
        this.lottoNumbersInfo = lottoNumbersInfo;
    }


    public BigDecimal getNumberOfLottoPurchased() {
        return purchaseInfo.purchaseAmount.divide(purchaseInfo.lottoPrice);
    }
}
