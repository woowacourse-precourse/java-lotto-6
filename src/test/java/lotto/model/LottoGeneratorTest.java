package lotto.model;

import static lotto.constants.Constant.LOTTO_NUMBER_COUNT;
import static lotto.constants.Constant.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.Constant.MINIMUM_LOTTO_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @DisplayName("로또를 생성하는 기능 테스트")
    @Test
    public void testGenerateNotNull() {
        Lotto lotto = LottoGenerator.generate();
        assertNotNull(lotto);

        List<Integer> numbers = lotto.getNumbers();
        assertEquals(LOTTO_NUMBER_COUNT, numbers.size());
        assertTrue(
                numbers.stream().allMatch(number -> number >= MINIMUM_LOTTO_NUMBER && number <= MAXIMUM_LOTTO_NUMBER));
    }
}