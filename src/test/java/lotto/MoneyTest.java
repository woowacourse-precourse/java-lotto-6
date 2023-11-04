package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1500, 200, 3020, 4500})
    @DisplayName("1000원단위로 입력하지 않으면 예외가 발생한다.")
    public void createByNotThousandWonUnits(Integer money) {
        assertThatThrownBy(() -> Money.of(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0원입력시 예외가 발생한다.")
    public void createByZeroWon() {
        assertThatThrownBy(() -> Money.of(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 800, 900, -1000})
    @DisplayName("1000원이하 입력시 예외가 발생한다.")
    public void createByMinThousandWon(Integer money) {
        assertThatThrownBy(() -> Money.of(money)).isInstanceOf(IllegalArgumentException.class);
    }

}
