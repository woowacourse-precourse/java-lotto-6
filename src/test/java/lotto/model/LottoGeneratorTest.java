package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoGeneratorTest {

    @Test
    public void testRandomNumberSize() {
        List<Integer> lottoNumbers = LottoGenerator.makeRandomNumbersInLotto();
        assertEquals(LottoGenerator.NUMBER_OF_LOTTO_NUMBER_IN_GAME, lottoNumbers.size());
    }

    @Test
    public void testNumberRange() {
        List<Integer> lottoNumbers = LottoGenerator.makeRandomNumbersInLotto();
        for (int number : lottoNumbers) {
            assertTrue(number >= LottoGenerator.MINIMUM_LOTTO_NUMBER);
            assertTrue(number <= LottoGenerator.MAXIMUM_LOTTO_NUMBER);
        }
    }

    @Test
    public void testNoDuplicates() {
        List<Integer> lottoNumbers = LottoGenerator.makeRandomNumbersInLotto();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            for (int j = i + 1; j < lottoNumbers.size(); j++) {
                assertNotEquals(lottoNumbers.get(i), lottoNumbers.get(j));
            }
        }
    }

    @Test
    public void testSortedOrder() {
        List<Integer> lottoNumbers = LottoGenerator.makeRandomNumbersInLotto();
        for (int i = 1; i < lottoNumbers.size(); i++) {
            assertTrue(lottoNumbers.get(i - 1) < lottoNumbers.get(i));
        }
    }
}
