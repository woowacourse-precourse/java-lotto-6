package lotto;

import model.MyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyLottoTest {
    @DisplayName("사용자가 1000원 단위가 아닌 값을 입력시 예외가 발생한다.")
    @Test
    void createMyLottoByNumberNotDivisibleBy1000() {
        assertThatThrownBy(() -> new MyLotto(6001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}