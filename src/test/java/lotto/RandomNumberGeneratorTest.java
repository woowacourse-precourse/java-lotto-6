package lotto;

import static lotto.LottoRule.MAXIMUM;
import static lotto.LottoRule.MINIMUM;
import static lotto.LottoRule.SIZE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();

    }

    @RepeatedTest(10)
    @DisplayName("1-45 사이의 숫자를 생성한다.")
    @Test
    void generateRandomNumber() {
        List<Integer> lottos = randomNumberGenerator.generate();

        lottos.stream().forEach(lotto ->
                assertThat(lotto).isBetween(MINIMUM.getValue(), MAXIMUM.getValue()));
    }

    @DisplayName("1-45 사이의 숫자를 6개 생성한다.")
    @Test
    void generateRandomNumberSize() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> lottos = randomNumberGenerator.generate();

        assertEquals(lottos.size(), SIZE.getValue());
    }
}
