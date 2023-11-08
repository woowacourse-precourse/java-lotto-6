package domain;

import lotto.domain.model.Money;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @Nested
    @DisplayName("유효한 금액 테스트")
    class ValidAmount {


        @ParameterizedTest
        @ValueSource(ints = {1000, 2000, 5000})
        @DisplayName("유효한 금액으로 Money 객체 생성")
        void createWithValidAmount(int validAmount) {
            Money money = new Money(validAmount);
            assertThat(money.getAmount()).isEqualTo(validAmount);
        }

        @ParameterizedTest
        @ValueSource(ints = {-1000, -2000, -5000})
        @DisplayName("음수 금액으로 Money 객체 생성 시 예외 발생")
        void createWithInvalidAmount(int invalidAmount) {
            assertThatThrownBy(() -> new Money(invalidAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("금액은 양수여야 합니다.");
        }
    }
}