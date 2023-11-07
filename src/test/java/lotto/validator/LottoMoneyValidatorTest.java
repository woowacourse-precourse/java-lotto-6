package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessages;
import org.junit.jupiter.api.Test;

class LottoMoneyValidatorTest {

    @Test
    void validate() {
        String notNumber = "notNumber";
        assertThatThrownBy(() -> LottoMoneyValidator.validate(notNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NOT_NUMBER.getMessage());

        String notEnoughMoney = "500";
        assertThatThrownBy(() -> LottoMoneyValidator.validate(notEnoughMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NOT_ENOUGH_MONEY.getMessage());

        String notThousands = "1500";
        assertThatThrownBy(() -> LottoMoneyValidator.validate(notThousands))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NOT_THOUSAND.getMessage());


    }

}