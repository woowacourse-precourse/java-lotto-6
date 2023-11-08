package lotto.domain.lotto;

import lotto.domain.lotto.RandomNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();

    @DisplayName("숫자 6개 생성 테스트")
    @Test
    void RandomGeneratorTest() {
        List<Integer> randomNumbers = randomNumbersGenerator.generate();
        assertThat(randomNumbers.size()).isEqualTo(6);
    }
}