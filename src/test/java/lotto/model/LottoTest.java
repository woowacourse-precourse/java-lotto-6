package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("6개의 숫자가 잘 들어갔는지 확인")
    @Test
    void testLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        String result = lotto.toString();

        assertEquals("[1, 2, 3, 4, 5, 6]", result);
    }

    @DisplayName("5개의 숫자가 들어갔을 때 예외 발생")
    @Test
    void testInvalidLottoSize() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
    }

    @DisplayName("중복 숫자가 들어갔을 때 예외발생")
    @Test
    void testInvalidDuplicateNumbers() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 5);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
    }

    @DisplayName("iterator가 잘 동작하는지 확인")
    @Test
    void testIterator() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        int sum = 0;
        for (Integer number : lotto) {
            sum += number;
        }

        assertEquals(21, sum);
    }
}