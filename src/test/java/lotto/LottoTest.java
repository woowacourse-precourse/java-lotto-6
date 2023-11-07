package lotto;

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

    @DisplayName("로또 번호의 개수가 6개가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 2개 이상 있으면 예외가 발생한다.")
    @Test
    void createLottoByDoubleDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 2, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByUnderRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 46, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("2개 이상의 로또 번호의 범위가 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByDoubleRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 46, 4, 100, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}