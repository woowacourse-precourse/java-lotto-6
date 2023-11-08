package lotto.domain;

import static lotto.domain.LottoDetails.lottoNumberMinimum;
import static lotto.domain.LottoDetails.lottoNumberMaximum;
import static lotto.view.ErrorMessage.printBonusNumberRangeError;

public class BonusNumber {

    private final int value;

    public BonusNumber(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if(value < lottoNumberMinimum() || value > lottoNumberMaximum()) {
            printBonusNumberRangeError();
            throw new IllegalArgumentException();
        }
    }
}
