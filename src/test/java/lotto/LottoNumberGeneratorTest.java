package lotto;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import lotto.service.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LottoNumberGeneratorTest {

    @Test
    public void testGenerateLottoNumbers() {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
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
인