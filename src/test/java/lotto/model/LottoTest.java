package lotto.model;

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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 포함된 숫자면 true를 반환한다")
    @Test
    void returnTrueWhenNumberIsPartOfLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertTrue(lotto.contains(6));
    }

    @DisplayName("로또 번호에 포함되지 않은 숫자면 false를 반환한다")
    @Test
    void returnFalseWhenNumberIsNotPartOfLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertFalse(lotto.contains(7));
    }

    @DisplayName("두 로또 번호가 일치하는 숫자의 개수만큼 반환한다")
    @Test
    void countMatchingNumberTest() {
        Lotto thisLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto thatLotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        int actual = thisLotto.countMatchingNumber(thatLotto);
        int expected = 2;
        assertEquals(actual, expected);
    }

}