package lotto.model;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public class LottoCount {

    private Integer count;

    public LottoCount(Integer purchaseAmount) {
        validateUnit(purchaseAmount);
        this.count = purchaseAmount / LottoConstant.LOTTO_UNIT;
    }

    public void validateUnit(Integer purchaseAmount) {
        if ((purchaseAmount % LottoConstant.LOTTO_UNIT) != 0) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.INVALID_LOTTO_UNIT_EXCEPTION_MESSAGE, LottoConstant.LOTTO_UNIT));
        }
    }

    public Integer getValue() {
        return count;
    }


}
