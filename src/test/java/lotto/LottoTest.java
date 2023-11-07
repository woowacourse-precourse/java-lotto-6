package lotto;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 번호에 중복된 숫자가 없는 경우 생성된다.")
    @Test
    void createLottoByUniqueNumbers() {
        List<Integer> uniqueNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(uniqueNumbers);
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrderElementsOf(uniqueNumbers);
    }

    @DisplayName("로또 번호에 숫자가 1 미만인 경우 예외가 발생한다.")
    @Test
    void createLottoByLessThanMinNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 45를 초과하는 경우 예외가 발생한다.")
    @Test
    void createLottoByMoreThanMaxNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
