package lotto.util;

import static lotto.domain.lotto.LottoRule.MAXIMUM;
import static lotto.domain.lotto.LottoRule.MINIMUM;
import static lotto.domain.lotto.LottoRule.SIZE;
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
    void generateRandomNumber() {
        // given & when
        List<Integer> lottos = randomNumberGenerator.generate();

        // then
        lottos.stream().forEach(lotto ->
                assertThat(lotto).isBetween(MINIMUM.getValue(), MAXIMUM.getValue()));
    }

    @DisplayName("1-45 사이의 숫자를 6개 생성한다.")
    @Test
    void generateRandomNumberSize() {
        // given & when
        List<Integer> lottos = randomNumberGenerator.generate();

        // then
        assertEquals(lottos.size(), SIZE.getValue());
    }
}
