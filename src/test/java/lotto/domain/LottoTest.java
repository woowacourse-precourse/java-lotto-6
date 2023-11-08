package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호에 1미만의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByLowNumber() {
        List<Integer> numbers = new ArrayList<>(List.of(0, 2, 4, 1, 5, 3));

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45초과의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByHighNumber() {
        List<Integer> numbers = new ArrayList<>(List.of(46, 2, 4, 1, 5, 3));

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 리스트가 정렬이 되었는지 확인")
    @Test
    void CheckLottoNumberSorted() {
        List<Integer> numbers = new ArrayList<>(List.of(6, 2, 4, 1, 5, 3));
        Lotto lotto = new Lotto(numbers);
        List<Integer> sortedNumbers = lotto.getNumbers();

        assertThat(sortedNumbers).isSorted();
    }

}