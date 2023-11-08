package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @Test
    void generateNum_6개의_로또_번호_반환_성공한다() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        Lotto lotto = generator.generateNum();
        assertNotNull(lotto);
        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    void generateNum_범위내의_로또_번호_반환_성공한다() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        Lotto lotto = generator.generateNum();
        assertNotNull(lotto);
        assertEquals(6, lotto.getNumbers().size());

        for (int number : lotto.getNumbers()) {
            assertTrue(number >= 1 && number <= 45);
        }
    }
}
