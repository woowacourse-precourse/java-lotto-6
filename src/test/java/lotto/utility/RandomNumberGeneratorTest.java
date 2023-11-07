package lotto.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.configuration.RandomNumberConfig.*;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    @DisplayName("설정된 개수와 범위만큼의 임의의 숫자를 오름차순으로 생성한다.")
    @Test
    void test() {
        // given, when
        List<Integer> randomNumbers = RandomNumberGenerator.generateNotDuplicatedRandomNumbersOrderByAsc();

        // then
        assertThat(randomNumbers).hasSize(COUNT);

        for (int randomNumber : randomNumbers) {
            assertThat(randomNumber).isBetween(START_INCLUSIVE, END_INCLUSIVE);
        }

        for (int i = 0; i < randomNumbers.size() - 1; i++) {
            assertThat(randomNumbers.get(i)).isLessThan(randomNumbers.get(i + 1));
        }
    }
}
