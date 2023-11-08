package lotto.Model.BonusNumber;
import static lotto.Common.LottoValue.*;
import static lotto.Common.ErrorMessage.*;

import java.util.List;

public class BonusNumber {
    private final Integer BonusNumber;

    public BonusNumber(Integer number) {
        validateRange(number);
        this.BonusNumber = number;
    }


    private void validateRange(int number) {
        if (number < LOTTO_FIRST_NUMBER.getValue() || number > LOTTO_FINAL_NUMBER.getValue()) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }



    public Integer getBonusNumber() {
        return this.BonusNumber;
    }
}
