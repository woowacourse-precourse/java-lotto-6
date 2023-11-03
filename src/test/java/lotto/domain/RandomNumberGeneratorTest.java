package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("1 ~ 45 중복 없는 6개 숫자 리스트를 생성한다.")
    @Test
    void generate() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        List<Integer> numbers = randomNumberGenerator.generate();

        // then
        assertThat(numbers)
                .hasSize(6)
                .hasSize(Set.copyOf(numbers).size());

        numbers.forEach(number -> assertThat(number >= 1 && number <= 45).isTrue());
    }
}