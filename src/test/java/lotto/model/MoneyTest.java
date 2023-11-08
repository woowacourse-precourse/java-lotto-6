package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("사용자가 구매한 로또 티켓들의 총 수익률을 계산한다.")
    @Test
    void getTotalReturnRate() {
        // given
        Money money = new Money("8000");
        long totalPrize = 5000;

        // when
        double totalReturnRate = money.calculateReturnRate(totalPrize);

        // then
        assertThat(totalReturnRate).isEqualTo(62.5);
    }

    @DisplayName("구매 금액이 숫자로 입력되지 않았다면 예외가 발생한다.")
    @Test
    void createMoneyIsNotNumber() {
        assertThatThrownBy(() -> new Money("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 로또 가격 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyDividedWithPrice() {
        assertThatThrownBy(() -> new Money("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}