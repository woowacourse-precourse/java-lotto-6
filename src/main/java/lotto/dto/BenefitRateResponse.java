package lotto.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.model.LottoResult;

public class BenefitRateResponse {

    private static final Integer SCALE_DIGIT = 2;
    private static final Double HUNDRED = 100d;

    private final BigDecimal benefitRate;

    public BenefitRateResponse(LottoResult lottoResult, Integer purchaseAmount) {
        benefitRate = BigDecimal.valueOf(HUNDRED * lottoResult.getTotalPrize() / purchaseAmount)
            .setScale(SCALE_DIGIT, RoundingMode.HALF_UP).stripTrailingZeros();
    }

    public BigDecimal getBenefitRate() {
        return benefitRate;
    }
}
