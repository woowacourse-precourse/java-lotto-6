package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        //given&when

        //then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        //given&when

        //then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 숫자를 가진 Lotto 객체들은 동등하다")
    public void testEquals() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when&then
        assertTrue(lotto1.equals(lotto2));
    }

    @Test
    @DisplayName("다른 숫자를 가진 Lotto 객체들은 동등하지 않다")
    public void testNotEquals() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        // when&then
        assertFalse(lotto1.equals(lotto2));
    }

    @Test
    @DisplayName("같은 숫자를 가진 Lotto 객체들의 해시코드는 동일하다")
    public void testHashCode() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when&then
        assertEquals(lotto1.hashCode(), lotto2.hashCode());
    }

    @Test
    @DisplayName("다른 숫자를 가진 Lotto 객체들의 해시코드는 다르다")
    public void testNotEqualHashCode() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        // when&then
        assertNotEquals(lotto1.hashCode(), lotto2.hashCode());
    }

    @Test
    @DisplayName("Lotto 내에 숫자가 포함되는 메서드를 검증한다.")
    public void testContainsNumber() {
        // given
        int number = 6;
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when&then
        assertTrue(lotto.containsNumber(number));
    }
}