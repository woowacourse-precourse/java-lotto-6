package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @DisplayName("랜덤 숫자 개수 테스트")
    @Test
    void testRandomNumberSize() {
        int minNum = 1;
        int maxNum = 9;
        int size = 5;
        List<Integer> uniqueRandomNumbers = RandomNumberGenerator.makeUniQueRandomNumbers(minNum, maxNum, size);
        assertThat(uniqueRandomNumbers.size())
                .isEqualTo(size);
    }

    @DisplayName("랜덤 숫자 범위 테스트")
    @Test
    void testRandomNumberRange() {
        int minNum = 1;
        int maxNum = 9;
        int size = 3;
        List<Integer> numbers = RandomNumberGenerator.makeUniQueRandomNumbers(minNum, maxNum, size);
        assertThat(
                numbers.stream()
                        .allMatch(n -> n >= minNum && n <= maxNum)
        )
                .isTrue();
    }

    @DisplayName("랜덤 숫자 유일값 테스트")
    @Test
    void randomNumberUniqueTest() {
        int minNum = 1;
        int maxNum = 9;
        int size = 7;

        List<Integer> numbers = RandomNumberGenerator.makeUniQueRandomNumbers(minNum, maxNum, size);
        assertThat(
                numbers.stream()
                        .distinct()
                        .count()
        )
                .isEqualTo(numbers.size());
    }

}