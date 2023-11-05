package lotto.model;

import static lotto.constant.ErrorMessage.MONEY_LESS_THAN_ZERO;
import static lotto.constant.ErrorMessage.MONEY_WITH_REMAINDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoOwnerTest {

    @Nested
    @DisplayName("구매 금액으로 로또 소유자를 생성한다.")
    class getLottoOwner {
        @DisplayName("[성공] 로또 소유자는 구매 금액을 필드로 갖는다.")
        @Test
        void from() {
            // given
            long expected = 1000L;

            // when
            LottoOwner result = LottoOwner.from(expected);

            // then
            assertThat(result).hasFieldOrPropertyWithValue("money", expected);
        }

        @DisplayName("[실패] 구매 금액이 0보다 작으면 예외가 발생한다.")
        @Test
        void exception_Less_Than_Zero_Money() {
            // given
            long money = 0L;

            // when // then
            assertThatThrownBy(() -> LottoOwner.from(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(MONEY_LESS_THAN_ZERO.toString());
        }

        @DisplayName("[실패] 구매 금액이 로또 1개 가격로 나눌 때 나머지가 존재하면 예외가 발생한다.")
        @Test
        void exception_Divided_By_Divisor_With_Remainder() {
            // given
            long money = 999L;

            // when // then
            assertThatThrownBy(() -> LottoOwner.from(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(MONEY_WITH_REMAINDER.toString());
        }
    }

}
