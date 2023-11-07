package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NumberGeneratorTest {

    @DisplayName("로또 숫자를 생성한다.")
    @Test
    void generateNumberTest() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        // when
        List<Integer> numbers = numberGenerator.generateNumber();

        // then
        Assertions.assertDoesNotThrow(() -> {
            for (Integer number : numbers) {
                Assertions.assertTrue(number >= NumberConstraints.LOTTO_MIN_NUMBER.value() && number <= NumberConstraints.LOTTO_MAX_NUMBER.value());
            }
        });
    }

    @DisplayName("생성된 숫자 목록은 6개이다.")
    @Test
    void generateNumberSizeTest() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        // when
        List<Integer> numbers = numberGenerator.generateNumber();

        // then
        Assertions.assertEquals(NumberConstraints.LOTTO_PER_NUMBER.value(), numbers.size());
    }
}
