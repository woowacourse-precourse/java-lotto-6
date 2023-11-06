package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("로또 번호가 1~45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 특정 숫자를 포함하고 있으면 참을 리턴한다.")
    @Test
    void createLottoContainsNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(1)).isEqualTo(true);
    }

    @DisplayName("로또 번호가 특정 숫자를 포함하고 있지 않으면 거짓을 리턴한다.")
    @Test
    void createLottoNotContainsNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(7)).isEqualTo(false);
    }

    @DisplayName("로또 두 개를 비교하여 몇 개의 숫자가 일치하는 지 확인한다.")
    @Test
    void createTwoLottoAndCompare() {
        Lotto testLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto testLotto2 = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        assertThat(testLotto1.compareLotto(testLotto2)).isEqualTo(3);
    }
}