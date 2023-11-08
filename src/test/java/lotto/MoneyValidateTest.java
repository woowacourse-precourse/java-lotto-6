package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.MoneyValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyValidateTest {
    @DisplayName("1000원 이하의 값을 입력하면 예외가 발생한다.")
    @Test
    void testUnderThousand() {
        assertThatThrownBy(() -> MoneyValidate.validateMoney(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void testThousandUnits() {
        assertThatThrownBy(() -> MoneyValidate.validateMoney(3500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
