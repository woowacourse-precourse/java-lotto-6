package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyValidatorTest {

    @DisplayName("로또 금액은 정수이면서 1000원 단위여야 하고, 1000원 이상이어야 한다.")
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