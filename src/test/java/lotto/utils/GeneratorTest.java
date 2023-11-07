package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    @DisplayName("generateNumbers 메소드 : 숫자 생성 개수 테스트")
    @Test
    void generateNumbers_validateCount() {
        int count = 6;
        List<Integer> numbers = Generator.generateNumbers(1, 45, count);
        assertThat(numbers.size()).isEqualTo(count);
    }

    @DisplayName("generateNumbers 메소드 : 숫자 생성 범위 테스트")
    @Test
    void generateNumbers_validateRange() {
        int start = 1;
        int end = 45;
        List<Integer> numbers = Generator.generateNumbers(start, end, 6);
        for (int number : numbers) {
            System.out.println(number);
            assertThat(number).isBetween(start, end);
        }
    }
}