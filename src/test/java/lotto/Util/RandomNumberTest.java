package lotto.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    List<Integer> numbers;
    @BeforeEach
    public void generateRandomNumbers() {
        numbers = RandomNumber.generateRandomNumbers();
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

    private boolean checkUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>();
        return numbers.stream()
                .allMatch(number -> uniqueNumber.add(number));
    }
    
    private boolean checkNumberRange(List<Integer> numbers) {
        return numbers.stream()
            .allMatch(number -> number >= MIN_NUMBER_RANGE && number <= MAX_NUMBER_RANGE);
    }
}
