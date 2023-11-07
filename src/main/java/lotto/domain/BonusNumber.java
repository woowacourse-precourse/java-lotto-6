package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.util.ModelValidator;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        ModelValidator.validateOutOfRange(number,
                LottoConstant.START_LOTTO_NUMBER.value(), LottoConstant.END_LOTTO_NUMBER.value());
        this.number = number;
    }


}
