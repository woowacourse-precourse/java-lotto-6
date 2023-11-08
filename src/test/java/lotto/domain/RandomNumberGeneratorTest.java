package lotto.domain;

import lotto.global.utils.constant.LottoNumberType;
import lotto.global.utils.generator.NumberGenerator;
import lotto.global.utils.generator.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomNumberGeneratorTest {

    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @DisplayName("1미만의 수가 나올 수 없다.")
    @Test
    void should_appearGreaterZero_when_generateNumbers() {
        int count = 1000;

        for (int index = 0; index < count; index++) {
            List<Integer> numbers = randomNumberGenerator.generate();
            Assertions.assertThat(numbers).allMatch(number -> number >= 1);
        }
    }

    @DisplayName("1이상 45이하 이외의 숫자는 생성할 수 없다.")
    @Test
    void should_generateGreater1to45_when_inputCount_randomNumberGenerator() {

        List<Integer> randomNumbers = randomNumberGenerator.generate();

        boolean allNumbersInRange = randomNumbers.stream()
                .allMatch(number -> number >= LottoNumberType.MIN_NUMBER_OF_RANGE.getValue()
                        && number <= LottoNumberType.MAX_NUMBER_OF_RANGE.getValue());

        Assertions.assertThat(allNumbersInRange).isTrue();
    }

    @DisplayName("6자리 이외의 숫자를 생성할 수 없다.")
    @Test
    void should_generateRangeOf6_when_inputCount_randomNumberGenerator() {

        List<Integer> randomNumbers = randomNumberGenerator.generate();

        int randomNumbersSize = randomNumbers.size();
        Assertions.assertThat(randomNumbersSize).isEqualTo(LottoNumberType.LENGTH_OF_LOTTO.getValue());
    }
}