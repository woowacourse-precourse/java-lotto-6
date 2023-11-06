package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

        @DisplayName("성공: Money 는 더하기 연산을 수행한다.")
        @Test
        void call_addition_will_return_Money() {
                //given
               BigDecimal thousandWon = BigDecimal.valueOf(1000);
                Money money = new Money(thousandWon);
                Money money2 = new Money(thousandWon);

                //when
                Money result = money.addition(money2);

                //then
                assertThat(result).isNotNull();
                assertThat(result.getAmount()).isEqualTo(BigDecimal.valueOf(2000));
        }

        @DisplayName("성공: Money 는 빼기 연산을 수행한다.")
        @Test
        void call_subtraction_will_return_Money() {
                //given
                BigDecimal thousandWon = BigDecimal.valueOf(1000);
                Money money = new Money(thousandWon);
                Money money2 = new Money(thousandWon);

                //when
                Money result = money.subtraction(money2);

                //then
                assertThat(result).isNotNull();
                assertThat(result.getAmount()).isEqualTo(BigDecimal.ZERO);
        }

        @DisplayName("예외: Money 는 잔액이 부족한 경우 예외를 발생한다.")
        @Test
        void call_subtraction_will_throw_exception() {
                //given
                BigDecimal thousandWon = BigDecimal.valueOf(1000);
                BigDecimal twoThousandWon = BigDecimal.valueOf(2000);
                Money money = new Money(thousandWon);
                Money money2 = new Money(twoThousandWon);

                //when
                assertThatThrownBy(() -> money.subtraction(money2))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잔액이 부족합니다.");
        }
}
