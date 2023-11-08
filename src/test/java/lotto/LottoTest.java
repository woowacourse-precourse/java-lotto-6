package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    public void createLottoTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);

        assertEquals(numbers, lotto.getNumbers());
    }

    @Test
    public void validateNumbersSizeTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    public void validateNumbersDuplicateTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    public void validateNumbersWrongRangeTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    public void ascendingSortNumbersTest() {
        List<Integer> numbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        List<Integer> sortedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);

        assertEquals(sortedNumbers, lotto.getNumbers());
    }
}
