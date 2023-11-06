package lotto.domain.amount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.errorMessage.amount.AmountExceptionStatus;
import lotto.constant.errorMessage.amount.InvalidAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @ParameterizedTest
    @ValueSource(ints = {100020, 20200, 80030, 150300, 30002})
    @DisplayName("구입 금액은 1000 단위로 나누어 떨어져야 한다.")
    void amountIsNotDivisibleTest(final int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(InvalidAmountException.class)
                .hasMessageContaining(AmountExceptionStatus.AMOUNT_IS_NOT_DIVISIBLE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 2323, 421323, 3434, 3000})
    @DisplayName("생성자 정상 작동 테스트")
    void constructorTest(final int amount) {
        final Amount purchaseAmount = new Amount(amount);
        assertThat(purchaseAmount.getAmount()).isEqualTo(amount);
    }
}
