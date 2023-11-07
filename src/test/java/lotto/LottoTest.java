package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 숫자들을 오름차순으로 만들어 준다.")
    @Test
    void createAscendingNumber() {
        List<Integer> numbers = new ArrayList<>(List.of(2, 3, 8, 12, 41, 28));
        Lotto lotto = new Lotto(numbers);
        lotto.sort();
        assertThat(lotto.getNumbers()).isSorted();
    }

    @DisplayName("로또 숫자들을 전달한다.")
    @Test
    void createStringOfNumbers() {
        assertThat(new Lotto(List.of(2, 24, 32, 29, 45, 17)).getNumbers()).isInstanceOf(List.class);
    }
}