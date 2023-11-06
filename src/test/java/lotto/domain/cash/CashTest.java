package lotto.domain.cash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CashTest {

    @DisplayName("돈을 생성 시 단위에 대해,")
    @Nested
    class validateCashUnit {

        @DisplayName("단위와 맞지 않는 값으로 생성 시 예외가 발생한다.")
        @Test
        void createWithInvalidUnit() {
            // given
            int amount = CashConfig.CASH_UNIT.getValue() + 1;

            // when & then
            Assertions.assertThatThrownBy(() -> new Cash(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(CashExceptionMessages.INVALID_CASH_UNIT.getMessage());
        }

        @DisplayName("단위와 맞는 값으로 생성 시 예외가 발생하지 않는다.")
        @Test
        void createWithValidUnit() {
            // given
            int amount = CashConfig.CASH_UNIT.getValue();

            // when & then
            Assertions.assertThatCode(() -> new Cash(amount))
                    .doesNotThrowAnyException();
        }

    }

}
