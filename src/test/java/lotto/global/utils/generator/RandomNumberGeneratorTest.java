package lotto.global.utils.generator;

import lotto.global.utils.console.ConsoleUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    private static final int MIN_NUMBER_OF_RANGE = 1;
    private static final int MAX_NUMBER_OF_RANGE = 45;

    @DisplayName("RandomNumberGenerator는 1이상 45이하의 숫자를 입력된 count만큼 생성해야한다.")
    @Test
    void should_generateGreater1to45_when_inputCount_randomNumberGenerator() {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> randomNumbers = randomNumberGenerator.generate();

        boolean allNumbersInRange = randomNumbers.stream()
                .allMatch(number -> number >= MIN_NUMBER_OF_RANGE && number <= MAX_NUMBER_OF_RANGE);

        Assertions.assertThat(allNumbersInRange).isTrue();

    }
}