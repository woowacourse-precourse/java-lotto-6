package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("Lotto Class의 생성자 테스트")
    void getNumbers() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        List<Integer> numbers = lotto.getNumbers();
        // then
        assertEquals(6, numbers.size());
    }

    @Test
    @DisplayName("Lotto Class의 toString() 메소드 테스트")
    void testToString() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        String lottoString = lotto.toString();
        // then
        assertEquals("1, 2, 3, 4, 5, 6", lottoString);
    }
}