package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyInputValidatorTest {

    MoneyInputValidator moneyInputValidator = new MoneyInputValidator();

    @ParameterizedTest
    @CsvSource(value = {"1000, true", "33000, true", "1500, false", "33400, false"})
    @DisplayName("금액 1000단위 여부 테스트")
    void 금액_1000단위_여부_테스트(int money, boolean expected) {
        Assertions.assertThat(moneyInputValidator.isDividedThousand(money)).isEqualTo(expected);
    }
}