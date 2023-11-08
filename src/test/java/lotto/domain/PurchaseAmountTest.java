package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("구매 금액 도메인에")
class PurchaseAmountTest {

    @DisplayName("구매하게 될 로또 개수 요청시 1000을 나눈 개수를 반환한다.")
    @Test
    void numOfLotto() {
        // given
        final int amount = 10000;
        final PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        // when
        final int result = purchaseAmount.numOfLotto();

        // then
        assertThat(result).isEqualTo(amount / 1000);
    }

    @DisplayName("구매 금액 요청시 저장된 값을 반환한다.")
    @Test
    void toValue() {
        // given
        final int expected = 1000;
        final PurchaseAmount purchaseAmount = new PurchaseAmount(expected);

        // when
        final int result = purchaseAmount.toValue();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("생성시")
    @Nested
    class CreateValidation {

        @DisplayName("0 이하의 값인 경우 예외를 던진다.")
        @Test
        void hasNoAmount() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new PurchaseAmount(0))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1000으로 나누어 떨어지지 않으면 예외를 던진다.")
        @Test
        void isNotDivisibleBy1000() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new PurchaseAmount(1234))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
