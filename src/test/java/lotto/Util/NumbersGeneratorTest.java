package lotto.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersGeneratorTest {

    List<Integer> numbers;

    @BeforeEach
    public void generateRandomNumbers() {
        numbers = NumbersGenerator.generateRandomNumbers();
    }

    @Test
    @DisplayName("생성된 숫자의 개수는 6개")
    public void sizeTest() {
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("중복숫자 확인")
    public void uniqueTest() {
        assertTrue(checkUnique(numbers));
    }

    @Test
    @DisplayName("각 숫자의 범위는 1~45 사이")
    public void numberRangeTest() {
        assertTrue(checkNumberRange(numbers));
    }

    @Test
    @DisplayName("오름차순 테스트")
    public void acendingOrderTest() {
        assertTrue(checkAcendingOrder(numbers));
    }

    private boolean checkAcendingOrder(List<Integer> numbers) {
        return IntStream.range(1, numbers.size())
            .allMatch(i -> numbers.get(i - 1) <= numbers.get(i));
    }

    private boolean checkUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>();
        return numbers.stream()
            .allMatch(number -> uniqueNumber.add(number));
    }

    private boolean checkNumberRange(List<Integer> numbers) {
        return numbers.stream()
            .allMatch(number -> number >= NumbersGenerator.MIN_NUMBER_RANGE
                && number <= NumbersGenerator.MAX_NUMBER_RANGE);
    }
}
