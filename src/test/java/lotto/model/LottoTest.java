package lotto.model;

import static lotto.constants.Message.DUPLICATED_LOTTO_NUMBER;
import static lotto.constants.Message.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constants.Message.INVALID_LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_SIZE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBER);
    }

    @DisplayName("로또 번호가 중해진 범위를 넘어면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_RANGE);
    }

    @DisplayName("로또에 특정 번호가 포함되어 있는지 확인한다.")
    @Test
    public void testContains() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertTrue(lotto.contains(3));
        assertTrue(lotto.contains(6));
        assertFalse(lotto.contains(7));
    }

    @DisplayName("플레이어 로또가 당첨 로또와 몇 개의 숫자가 일치하는지 확인한다.")
    @Test
    public void testMatchCountWith() {
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));

        assertEquals(4, playerLotto.matchCountWith(winningLotto));
    }
}