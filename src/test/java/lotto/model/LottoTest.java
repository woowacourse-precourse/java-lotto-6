package lotto.model;

import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("로또 숫자 범위가 1~45가 아니면 예외가 발생한다.")
    void createLottoByNotRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또에 숫자가 들어가 있으면 true를 반환")
    void containLottoByNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        boolean hasNumber = lotto.hasNumber(3);
        // then
        Assertions.assertThat(hasNumber).isTrue();
    }

    @Test
    @DisplayName("로또에 숫자가 없으면 false를 반환")
    void notContainLottoByNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        boolean hasNumber = lotto.hasNumber(7);
        // then
        Assertions.assertThat(hasNumber).isFalse();
    }

    @Test
    @DisplayName("같은 숫자가 4개 일시 4를 반환해야한다.")
    void sameNumberCounterTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 10, 20), 40);
        // when
        int count = lotto.sameNumberCounter(winningNumbers);
        // then
        Assertions.assertThat(count).isEqualTo(4);

    }
}