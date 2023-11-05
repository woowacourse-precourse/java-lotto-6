package lotto.model;

import static lotto.constant.ErrorMessage.MONEY_LESS_THAN_ZERO;
import static lotto.constant.ErrorMessage.MONEY_WITH_REMAINDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @Nested
    @DisplayName("입력값으로 돈을 생성한다.")
    class getPurchasePrice {

        @DisplayName("[성공] 돈은 금액을 필드로 갖는다.")
        @Test
        void from() {
            // given
            long expected = 1000L;

            // when
            PurchasePrice result = PurchasePrice.from(expected);

            // then
            assertThat(result).hasFieldOrPropertyWithValue("amount", expected);
        }

        @DisplayName("[실패] 구매 금액이 0보다 작으면 예외가 발생한다.")
        @Test
        void exception_Less_Than_Zero_Money() {
            // given
            long money = 0L;

            // when // then
            assertThatThrownBy(() -> PurchasePrice.from(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(MONEY_LESS_THAN_ZERO.toString());
        }

        @DisplayName("[실패] 구매 금액이 로또 1개 가격로 나눌 때 나머지가 존재하면 예외가 발생한다.")
        @Test
        void exception_Divided_By_Divisor_With_Remainder() {
            // given
            long money = 999L;

            // when // then
            assertThatThrownBy(() -> PurchasePrice.from(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(MONEY_WITH_REMAINDER.toString());
        }
    }

    @DisplayName("구입금액으로 로또를 구입할 수 있는 개수를 구할 수 있다.")
    @Test
    void getQuotient() {
        // given
        long money = 2000L;
        long lottoPrice = 1000L;
        PurchasePrice purchasePrice = PurchasePrice.from(money);
        long expected = money / lottoPrice;

        // when
        long result = purchasePrice.getQuotient();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
