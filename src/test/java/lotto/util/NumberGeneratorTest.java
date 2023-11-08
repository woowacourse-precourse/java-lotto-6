package lotto.util;

import lotto.domain.LottoConfiguration;
import lotto.util.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    @DisplayName("중복되지 않는 6개의 숫자를 포함한 리스트를 생성한다.")
    void createNumbers() {
        List<Integer> numbers = NumberGenerator.generateNumbers();

        assertThat(numbers.size()).isEqualTo(LottoConfiguration.NUMBERS_SIZE);
        assertThat(containsNoDuplicates(numbers)).isTrue();
    }

    private boolean containsNoDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }
}
