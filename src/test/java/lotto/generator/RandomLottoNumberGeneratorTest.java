package lotto.generator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumberGeneratorTest {

    @DisplayName("로또 숫자는 오름차순으로 생성된다.")
    @Test
    void generate() {
        NumberGenerator generator = new RandomLottoNumberGenerator();

        List<Integer> numbers = generator.generate();
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();

        Assertions.assertThat(sortedNumbers).isEqualTo(numbers);
    }


}
