package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyValidatorTest {

    @Test
    public void 입력한_금액이_1000원_단위가_아니면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> MoneyValidator.validateMoney(1800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_금액이_음수인_경우_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> MoneyValidator.validateMoney(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}