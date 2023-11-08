package lotto;

import lotto.domain.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberGeneratorTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = RandomNumberGenerator.generateRandomNumbers();
    }

    @DisplayName("범위 안의 랜덤한 숫자를 생성한다.")
    @Test
    void generateRandomNumbersWithinRange() {
        assertThat(numbers.stream().allMatch(num -> num >= 1 && num <= 45)).isTrue();
    }

    @DisplayName("6개의 숫자는 중복되지 않는다.")
    @Test
    void generateRandomNumbersWithoutDuplicates() {
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }

    @DisplayName("리스트는 오름차순으로 정렬되어 있다.")
    @Test
    void generateRandomNumbersSorted() {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        assertThat(numbers).isEqualTo(sortedNumbers);
    }
}