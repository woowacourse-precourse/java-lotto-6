package lotto.model;

import static lotto.model.LottoInfo.LOTTO_MAX_NUMBER;
import static lotto.model.LottoInfo.LOTTO_MIN_NUMBER;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumberGeneratorTest {

    @DisplayName("1과 45사이의 숫자를 6개 뽑는다.")
    @Test
    void pickNumbersTest() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();

        // when
        List<Integer> numbers = lottoNumberGenerator.pickNumbers();

        // then
        Assertions.assertEquals(numbers.size(), 6);
        
        Integer min = LOTTO_MIN_NUMBER.getValue();
        Integer max = LOTTO_MAX_NUMBER.getValue();
        for (int number : numbers) {
            assertTrue(number >= min && number <= max);
        }
    }
}
