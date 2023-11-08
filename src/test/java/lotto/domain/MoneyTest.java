package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("사용자에게 입력받은 구매금액을 검증한다.- 문자를 포함한 금액은 예외를 발생시킨다.")
    @Test
    void createMoney_includeChar() {
        String money = "5x00";

        assertThatThrownBy(() -> Money.of(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 입력받은 구매금액을 검증한다.- 범위를 초과하거나 미만인 금액은 예외를 발생시킨다.")
    @Test
    void createMoney_invalidRange() {
        String blow = "-1";
        String rangeOver = String.valueOf(Double.MAX_VALUE);

        assertThatThrownBy(() -> Money.of(blow))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Money.of(rangeOver))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 입력받은 구매금액을 검증한다. - Lotto 장당 가격으로 나누어 떨어지지 않은 금액은 예외를 발생시킨다.")
    @Test
    void createMoney_invalidUnit() {
        String invalidUnit1 = "4500";
        String invalidUnit2 = "1099";

        assertThatThrownBy(() -> Money.of(invalidUnit1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Money.of(invalidUnit2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 입력받은 구매금액으로 몇 장의 로또를 살 수 있는지 반환한다.")
    @Test
    void getCountBuyLotto() {
        String moneyInput = "4000";

        Money money = Money.of(moneyInput);

        assertThat(money.getCountBuyLotto()).isEqualTo(4);
    }

    @DisplayName("투자한 금액 대비 수익률을 반환한다.")
    @Test
    void returnOfRate() {
        String moneyInput = "4000";

        Money money = Money.of(moneyInput);

        assertThat(money.returnOfProfitRate(2000)).isEqualTo(0.5);
    }
}