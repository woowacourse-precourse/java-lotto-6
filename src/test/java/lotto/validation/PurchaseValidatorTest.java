package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseValidatorTest {
    @DisplayName("유효하지 않은 구매 금액 문자열들을 예외 처리하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "1200"})
    void convertPurchaseAmountExceptionTest(String input) {
        //then
        assertThatThrownBy(() -> PurchaseValidator.validate(Integer.parseInt(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }
}