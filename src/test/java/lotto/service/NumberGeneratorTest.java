package lotto.service;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import lotto.service.NumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberGeneratorTest {

    @Test
    public void testGenerateLottoNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> lottoNumbers = numberGenerator.generateLottoNumber();

        assertNotNull(lottoNumbers);
        assertEquals(6, lottoNumbers.size());

        for (int lottoNumber : lottoNumbers) {
            assertTrue(lottoNumber >= 1 && lottoNumber <= 45);
        }

        Set<Integer> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        assertEquals(6, uniqueLottoNumbers.size());
    }
}