package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RandomNumberGenerator의")
class RandomNumberGeneratorTest {

    final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    @DisplayName("반환되는 숫자의 개수가 일치하는가")
    void is_size_equal() {
        //given & when
        final Integer size = 6;
        final List<Integer> randomNumbers = randomNumberGenerator.generateUniqueNumbers();

        //then
        assertThat(randomNumbers).hasSize(size);
    }
}
