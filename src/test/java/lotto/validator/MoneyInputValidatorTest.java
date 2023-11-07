package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyInputValidatorTest {

    BasicValidator<String> moneyInputValidator = new MoneyInputValidator();

    @Test
    void 로또_구입_금액에_대한_입력값_검증() {
        assertThatThrownBy(() -> moneyInputValidator.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 숫자가 아닙니다.");

        assertThatThrownBy(() -> moneyInputValidator.validate("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 0보다 커야 합니다.");

        assertThatThrownBy(() -> moneyInputValidator.validate("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.");

        assertThatThrownBy(() -> moneyInputValidator.validate("999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
    }
}