package lotto.util;

import static lotto.constant.Constant.LOTTO_CNT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoRandomNumbersGeneratorTest {

    @Test
    void getLottoNumbers() {
        List<Integer> numbers = LottoRandomNumbersGenerator.generate();

        assertNotNull(numbers);
        assertEquals(numbers.size(), LOTTO_CNT);
    }

}