package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @DisplayName("로또 번호에 1부터 45사이의 범위가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 12, 23, 34, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("sortLotto 메소드에서 번호가 잘 정렬되는지 테스트")
    @Test
    void sortLottoTest() {
        Lotto lotto = new Lotto(Arrays.asList(32, 5, 19, 8, 22, 13));
        List<Integer> sortedNumbers = lotto.sortLotto(lotto.getNumbers());

        assertThat(sortedNumbers).containsExactly(5, 8, 13, 19, 22, 32);
    }
}