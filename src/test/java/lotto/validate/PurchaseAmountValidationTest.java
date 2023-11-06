package lotto.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PurchaseAmountValidationTest {

    private final LottoValidation lottoValidation = new PurchaseAmountValidation();

    @DisplayName("입력한 금액이 숫자가 아니라면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"가", "100나", "1가0", "kwy"})
    void purchaseValidationTest(final String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("입력한 금액이 1,000 단위가 아니라면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "2003", "2450", "1999","2000004", "10", "100"})
    void purchaseValidationTest2(final String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("입력한 금액이 1,000 단위일 때 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "100000", "112000"})
    void purchaseValidationTest4(final String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("입력한 금액이 음수일 때 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-2000", "-100000", "-112000"})
    void purchaseValidationTest5(final String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }
}