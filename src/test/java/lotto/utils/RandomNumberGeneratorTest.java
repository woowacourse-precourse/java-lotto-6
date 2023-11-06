package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomNumberGeneratorTest {

    @DisplayName("start에서 end 사이의 숫자를 뽑을 수 있다")
    @ParameterizedTest
    @CsvSource(textBlock = """
            1, 1, 1
            1, 2, 2
            1, 45, 30
            """)
    void generateInRangeNumbers(int startInclusive, int endInclusive, int count) {

        List<Integer> generated =
                RandomNumberGenerator.generateUniqueNumbersInRange(startInclusive, endInclusive, count);

        boolean isInRange = generated.stream()
                .allMatch(number -> number >= startInclusive && number <= endInclusive);
        assertThat(isInRange).isTrue();
    }

    @DisplayName("중복되지 않는 숫자 count개를 뽑을 수 있다")
    @ParameterizedTest
    @CsvSource(textBlock = """
            1, 1, 1
            1, 2, 2
            1, 45, 30
            """)
    void generateUniqueNumbersAsCount(int startInclusive, int endInclusive, int count) {

        List<Integer> generated =
                RandomNumberGenerator.generateUniqueNumbersInRange(startInclusive, endInclusive, count);

        long uniqueNumberCount = generated.stream().mapToInt(number -> number)
                .distinct()
                .count();
        assertThat(uniqueNumberCount).isEqualTo(count);
    }
}
