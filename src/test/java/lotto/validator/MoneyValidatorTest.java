package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {
    @Test
    void 숫자_형식_확인() {
        String money = "abc";

        assertThatThrownBy(() -> MoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈값_확인() {
        String money = "";

        assertThatThrownBy(() -> MoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_확인() {
        String money = " ";

        assertThatThrownBy(() -> MoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_단위_확인() {
        String money = "14001";

        assertThatThrownBy(() -> MoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
