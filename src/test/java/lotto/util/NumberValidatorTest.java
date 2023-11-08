package lotto.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {
    @DisplayName("로또 구매 금액으로 정상적인 값이 전달 됬을 경우 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000})
    void testVerifyPurchaseAmountSuccess(Integer amount) {
        assertThatCode(() -> {
            NumberValidator.verifyPurchaseAmount(amount);
        }).doesNotThrowAnyException();
    }

    @DisplayName("로또 구매 금액으로 잘못된 값이 전달 됬을 경우 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {-1, 0, 1111, 999999999})
    void testVerifyPurchaseAmountFail(Integer amount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumberValidator.verifyPurchaseAmount(amount);
        });
    }
}