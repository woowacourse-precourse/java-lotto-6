package lotto.domain.repository;

import java.util.List;
import lotto.enums.LottoRule;
import lotto.enums.UserInterfaceMessage;

public class LottoBonus {
    private final Integer bonusNumber;

    public LottoBonus(Integer bonusNumber, List<Integer> LottoNumber) {
        validate(bonusNumber, LottoNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer number, List<Integer> lottoNumber) {
        if (number < LottoRule.START.getValue() || number > LottoRule.END.getValue()) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_NUMBER_INCLUSIVE.getValue(),
                    LottoRule.START.getValue(), LottoRule.END.getValue()));
        }
        if (lottoNumber.contains(number)) {
            throw new IllegalArgumentException(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_DUPLICATED.getValue());
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
