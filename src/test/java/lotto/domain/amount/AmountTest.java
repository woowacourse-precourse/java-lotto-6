package lotto.domain.amount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.errorMessage.amount.AmountExceptionStatus;
import lotto.constant.errorMessage.amount.IllegalStateAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    private void exceptionVerification(final int amount, final String message) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalStateAmountException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -10000, -2000, -100})
    @DisplayName("양의 정수가 아닌 구입 금액은 입력될 수 없다.")
    void amountIsNotPositive(final int amount) {
        String message = AmountExceptionStatus.AMOUNT_IS_NOT_POSITIVE.getMessage();
        exceptionVerification(amount, message);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 100, 990, 340, 200})
    @DisplayName("1000 보다 작은 구입 금액은 입력될 수 없다.")
    void amountIsNotAboveTest(final int amount) {
        String message = AmountExceptionStatus.AMOUNT_IS_NOT_ABOVE.getMessage();
        exceptionVerification(amount, message);
    }

    @ParameterizedTest
    @ValueSource(ints = {100020, 20200, 80030, 150300, 30002})
    @DisplayName("1000 단위로 나누어 떨어지지 않는 구입 금액은 입력될 수 없다.")
    void amountIsNotDivisibleTest(final int amount) {
        String message = AmountExceptionStatus.AMOUNT_IS_NOT_DIVISIBLE.getMessage();
        exceptionVerification(amount, message);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 40000, 15000, 8000, 3000})
    @DisplayName("생성자 정상 작동 테스트")
    void constructorTest(final int amount) {
        final Amount purchaseAmount = new Amount(amount);
        assertThat(purchaseAmount.amount()).isEqualTo(amount);
    }
}
