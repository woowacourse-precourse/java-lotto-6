package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersGeneratorTest {
    @DisplayName("정렬된 숫자가 생성된다.")
    @Test
    void createNumbersBySorted() {
        List<Integer> result = NumbersGenerator.generate();
        List<Integer> sortedResult = result;
        Collections.sort(sortedResult);

        assertThat(result).isEqualTo(sortedResult);
    }

    @DisplayName("생성된 숫자가 6개의 숫자이다")
    @Test
    void chcekNumbersSize() {
        List<Integer> result = NumbersGenerator.generate();

        assertThat(result.size()).isEqualTo(6);
    }

}