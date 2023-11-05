package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LotteriesTest {

    @Nested
    @DisplayName("구입 금액 검증 테스트")
    class ValidationTest {

        @ParameterizedTest(name = "구입 금액 : {0}")
        @CsvSource({"2999", "3001", "4500"})
        @DisplayName("구입 금액이 1,000으로 안나눠 떨어질 경우, 예외를 던진다")
        void validationTest_whenPurchaseAmountNotDividedByPrice(int purchaseAmount) {

            assertThatThrownBy(() -> Lotteries.from(purchaseAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("구입 금액은 한 장의 가격(1000)으로 나누어 떨어져야 합니다");
        }

        @ParameterizedTest(name = "구입 금액 : {0}")
        @CsvSource({"-1", "-1000", "-3000", "0"})
        @DisplayName("구입 금액이 음수이거나 0인 경우, 예외를 던진다")
        void validationTest_whenPurchaseAmountIsNegative(int purchaseAmount) {

            assertThatThrownBy(() -> Lotteries.from(purchaseAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("구입 금액 양수 이어야 합니다");
        }
    }
}
