package lotto.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.model.LottoInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("1과 45사이의 숫자를 6개 뽑는다.")
    @Test
    void pickNumbersTest() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        // when
        List<Integer> numbers = numberGenerator.pickNumbers();

        // then
        Assertions.assertEquals(numbers.size(), 6);

        Integer min = LottoInfo.LOTTO_MIN_NUMBER.getValue();
        Integer max = LottoInfo.LOTTO_MAX_NUMBER.getValue();

        for (int number : numbers) {
            assertTrue(number >= min && number <= max);
        }
    }
}
