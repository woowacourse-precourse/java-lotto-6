package lotto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만일 경우 예외가 발생한다.")
    @Test
    void createLottoByString() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호가 45 초과의 숫자를 입력할 경우 예외가 발생한다.")
    @Test
    void createMaxNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호가 1 미만의 숫자를 입력할 경우 예외가 발생한다.")
    @Test
    void createMinNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(-3, 0, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}