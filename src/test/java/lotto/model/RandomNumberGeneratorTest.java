package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    @RepeatedTest(10)
    void 숫자_생성기는_정해진_개수만큼_숫자를_생성한다() {
        NumberGenerator generator = new RandomNumberGenerator();

        List<Integer> numbers = generator.generateUniqueNumbers(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);

        assertThat(numbers).hasSize(NUMBER_SIZE);
    }

    @RepeatedTest(10)
    void 숫자_생성기는_중복되지_않는_숫자를_생성한다() {
        NumberGenerator generator = new RandomNumberGenerator();

        List<Integer> numbers = generator.generateUniqueNumbers(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);

        assertThat(numbers).doesNotHaveDuplicates();
    }

    @RepeatedTest(10)
    void 숫자_생성기는_정해진_범위의_숫자를_생성한다() {
        NumberGenerator generator = new RandomNumberGenerator();

        List<Integer> numbers = generator.generateUniqueNumbers(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);

        assertThat(numbers).hasSizeBetween(MIN_NUMBER, MAX_NUMBER);
    }

}
