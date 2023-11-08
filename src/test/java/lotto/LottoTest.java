package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.model.Lotto;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfTheRangeNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자들이 같으면 같은 로또 번호이다.")
    @Test
    void isEqualNumbersIsEqual() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(lotto1, lotto2);
        assertEquals(lotto1.hashCode(), lotto2.hashCode());
    }

    @DisplayName("값이 로또 numbers에 존재하면 true 반환")
    @Test
    void testContainsTrue() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int value = 1;

        assertTrue(lotto.contains(value));
    }

    @DisplayName("값이 로또 numbers에 존재하지 않으면 false 반환")
    @Test
    void testContainsFalse() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int value = 7;

        assertFalse(lotto.contains(value));
    }

    @DisplayName("다른 Lotto 객체와 일치하는 개수 반환")
    @Test
    void testMatchingCount() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        int expected = 3;

        int matchingCount = lotto1.getMatchingCount(lotto2);

        assertEquals(expected, matchingCount);
    }

    @Test
    void testLottoEquals() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(lotto1, lotto1);
        assertNotEquals(lotto1, List.of(1, 2, 3, 4, 5, 6));
        assertNotEquals(lotto1, null);
    }
}