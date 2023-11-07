package lotto.domain;

import lotto.utils.LottoNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    public void testLottoNumbersGenerator() {
        List<Integer> numbers = LottoNumbersGenerator.generateLottoNumbers();
        assertNotNull(numbers);
        assertEquals(6, numbers.size());
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    public void testGetLottoNumbersFromString() {
        Lotto lotto = new Lotto();
        String input = "1,2,3,4,5,6";
        List<Integer> numbers = lotto.getLottoNumbers(input);
        assertNotNull(numbers);
        assertEquals(6, numbers.size());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), numbers);
    }

    @Test
    public void testGetLottoNumbers() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(inputNumbers);
        List<Integer> numbers = lotto.getLottoNumbers();
        assertNotNull(numbers);
        assertEquals(6, numbers.size());
        assertEquals(inputNumbers, numbers);
    }

    @Test
    public void testGetLottoNumbersAsString() {
        String input = "1,2,3,4,5,6";
        List<String> numbers = Lotto.getLottoNumbersAsString(input);
        assertNotNull(numbers);
        assertEquals(6, numbers.size());
        assertEquals(Arrays.asList("1", "2", "3", "4", "5", "6"), numbers);
    }

    @Test
    public void testGetLottoNumbersSplit() {
        String input = "1,2,3,4,5,6";
        String[] splitNumbers=input.split(",");
        assertNotNull(splitNumbers);
        assertEquals(6, splitNumbers.length);
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, splitNumbers);
    }

    @Test
    public void testValidationWithValidNumbers() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertNotNull(lotto);
    }

    @Test
    public void testValidationWithInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);
            new Lotto(invalidNumbers);
        });
    }
}
