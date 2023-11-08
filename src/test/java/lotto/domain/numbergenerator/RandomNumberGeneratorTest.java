package lotto.domain.numbergenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.*;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator;

    @DisplayName("숫자 생성 테스트")
    @RepeatedTest(100)
    void generate() {
        randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> randomNumber = randomNumberGenerator.generate();

        randomNumber.forEach(number -> assertThat(number).isBetween(1, 45));
    }
}
