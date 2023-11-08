package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> Lotto.of(List.of(55, 68, 111, -30, 0, 40)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공 번호 일치 개수 카운트")
    @Test
    void countSameBallNumbers() {
        assertEquals(Lotto.of(List.of(1, 2, 3, 4, 5, 6))
                .countMatchingNumbers(Lotto.of(List.of(6, 5, 4, 3, 11, 12))), 4);
    }
}