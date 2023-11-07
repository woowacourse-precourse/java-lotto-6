package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("투입금액이 1000원 이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {0, 100, 500, 900, 999})
    void lackMoneyException(long money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 이상 투입 되어야 합니다.");
    }

    @DisplayName("투입금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {1001, 1500, 9700, 15000006})
    void wrongMoneyException(long money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 단위로 투입 되어야 합니다.");
    }

    @DisplayName("투입금액에 따른 발행 갯수를 반환한다.")
    @ParameterizedTest
    @ValueSource(longs = {1000, 3000, 80000})
    void getPurchaseCount(long money) {
        // given
        Money testMoney = new Money(money);
        int expectCount = (int) testMoney.getMoney() / 1000;

        // when
        int purchaseCount = testMoney.getPurchaseCount();

        // then
        assertThat(purchaseCount).isEqualTo(expectCount);
    }
}
