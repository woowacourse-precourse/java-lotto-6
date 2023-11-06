package lotto.domain.cash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CashTest {

    private final int CASH_UNIT = CashConfig.CASH_UNIT.getValue();

    @DisplayName("돈을 생성 시 단위에 대해,")
    @Nested
    class validateCashUnit {

        @DisplayName("단위와 맞지 않는 값으로 생성 시 예외가 발생한다.")
        @Test
        void createWithInvalidUnit() {
            // given
            int amount = CASH_UNIT + 1;

            // when & then
            Assertions.assertThatThrownBy(() -> new Cash(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(CashExceptionMessages.INVALID_CASH_UNIT.getMessage());
        }

        @DisplayName("단위와 맞는 값으로 생성 시 예외가 발생하지 않는다.")
        @Test
        void createWithValidUnit() {
            // given
            int amount = CASH_UNIT;

            // when & then
            Assertions.assertThatCode(() -> new Cash(amount))
                    .doesNotThrowAnyException();
        }

    }


    @DisplayName("돈을 생성 시 양수인가에 대해,")
    @Nested
    class validatePositive {

        @DisplayName("0으로 생성 시 예외가 발생한다.")
        @Test
        void createWithZero() {
            // given
            int amount = 0;

            // when & then
            Assertions.assertThatThrownBy(() -> new Cash(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(CashExceptionMessages.NEGATIVE_OR_ZERO.getMessage());
        }

        @DisplayName("음수로 생성 시 예외가 발생한다.")
        @Test
        void createWithNegative() {
            // given
            int amount = - CASH_UNIT;

            // when & then
            Assertions.assertThatThrownBy(() -> new Cash(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(CashExceptionMessages.NEGATIVE_OR_ZERO.getMessage());
        }

        @DisplayName("양수로 생성 시 예외가 발생하지 않는다.")
        @Test
        void createWithPositive() {
            // given
            int amount = CASH_UNIT;

            // when & then
            Assertions.assertThatCode(() -> new Cash(amount))
                    .doesNotThrowAnyException();
        }

    }

}
