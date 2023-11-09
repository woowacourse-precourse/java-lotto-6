package lotto.domain.money;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1500, 200, 3020, 4500})
    @DisplayName("1000원단위로 입력하지 않으면 예외가 발생한다.")
    public void createByNotThousandWonUnits(Integer money) {
        assertThatThrownBy(() -> Money.from(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 800, 900, -1000})
    @DisplayName("1000원미만 입력시 예외가 발생한다.")
    public void createByMinThousandWon(Integer money) {
        assertThatThrownBy(() -> Money.from(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000000, 2000})
    @DisplayName("지폐의 개수를 반환한다")
    public void returnBllCount(Integer input) {
        Money money = Money.from(input);

        assertThat(money.calcBillCount()).isEqualTo(input / 1000);
    }
}
