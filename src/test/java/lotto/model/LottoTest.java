package lotto.model;

import lotto.view.Messages;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

    @Test
    public void testLottoInitialization() {
        List<Integer> validLottoNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        Lotto validLotto = new Lotto(validLottoNumbers);
        assertNotNull(validLotto);
        assertIterableEquals(validLottoNumbers, validLotto.getNumbers());
    }

    @Test
    public void testLottoInvalidSize() {
        List<Integer> invalidSizeLotto = Arrays.asList(5, 10, 15, 20, 25);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidSizeLotto));
        assertEquals(Messages.LOTTO_NUMBER_SIZE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void testLottoOutOfRangeNumber() {
        List<Integer> outOfRangeLotto = Arrays.asList(5, 10, 15, 60, 25, 30);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(outOfRangeLotto));
        assertEquals(Messages.LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void testLottoDuplicateNumbers() {
        List<Integer> duplicateNumbersLotto = Arrays.asList(5, 10, 15, 20, 25, 15);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(duplicateNumbersLotto));
        assertEquals(Messages.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    public void testLottoContains() {
        List<Integer> lottoNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        Lotto lotto = new Lotto(lottoNumbers);

        assertTrue(lotto.contains(20));
        assertFalse(lotto.contains(35));
    }
}
