package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 범위가 유효하고 개수가 맞으며 중복되지 않으면 예외가 발생하지 않는다.")
    @Test
    void createLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> new Lotto(numbers));
    }

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

    @DisplayName("로또 번호에 1 미만 45 초과인 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRange() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 일치하는 번호 개수를 반환한다.")
    @Test
    void countMatchedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int actual = lotto.countMatchedNumber(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(actual).isEqualTo(5);
    }
}
