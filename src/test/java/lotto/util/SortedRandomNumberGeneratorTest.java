package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SortedRandomNumberGeneratorTest {
    @Test
    void 로또_번호를_오름차순으로_정렬하여_보여준다() {
        SortedRandomNumberGenerator sortedRandomNumberGenerator = new SortedRandomNumberGenerator();

        List<Integer> numbers = sortedRandomNumberGenerator.generate();

        assertThat(numbers.stream().sorted().toList()).isEqualTo(numbers);
    }
}