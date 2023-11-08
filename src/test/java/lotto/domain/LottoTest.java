package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 번호가 1과 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 로또 번호와 일치하는 번호의 개수를 반환한다.")
    @Test
    void countMatchedNumbers() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int count = lotto1.countMatchedNumbers(lotto2);
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("특정 번호가 로또 번호에 포함되어 있는지 확인한다.")
    @Test
    void contains() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }
}