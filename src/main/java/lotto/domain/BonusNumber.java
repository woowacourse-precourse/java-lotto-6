package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.util.ModelValidator;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(Integer number) {
        ModelValidator.validateOutOfRange(number,
                LottoConstant.START_LOTTO_NUMBER.value(), LottoConstant.END_LOTTO_NUMBER.value());
        this.number = number;
    }


}
