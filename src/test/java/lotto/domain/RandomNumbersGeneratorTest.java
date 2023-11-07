package lotto.domain;

import java.util.List;
import lotto.global.utils.generator.NumbersGenerator;
import lotto.global.utils.generator.RandomNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersGeneratorTest {

    private final NumbersGenerator numbersGenerator = new RandomNumbersGenerator();

    @DisplayName("1미만의 수가 나올 수 없다.")
    @Test
    void should_appearGreaterZero_when_generateNumbers() {
        int count = 1000;

        for (int index = 0; index < count; index++) {
            List<Integer> numbers = numbersGenerator.generate();
            Assertions.assertThat(numbers).allMatch(number -> number >= 1);
        }
    }

    @DisplayName("45초과의 수가 나올 수 없다.")
    @Test
    void should_appearLess46_when_generateNumbers() {
        int count = 1000;

        for (int index = 0; index < count; index++) {
            List<Integer> numbers = numbersGenerator.generate();
            Assertions.assertThat(numbers).allMatch(number -> number <= 45);
        }
    }

    @DisplayName("중복된 수가 나올 수 없다.")
    @Test
    void should_appearDistinct_when_generateNumbers() {
        int count = 1000;

        for (int index = 0; index < count; index++) {
            List<Integer> numbers = numbersGenerator.generate();
            Assertions.assertThat(numbers).doesNotHaveDuplicates();
        }
    }
}
