package lotto.Test.FunctionTest;
import lotto.model.lottoGenerator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("생성된 숫자 리스트는 6개의 숫자를 포함해야 한다")
    public void ReturnSixNumbersTest() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Integer> numbers = generator.generateNumbers();
        assertEquals(6, numbers.size(), "생성된 숫자의 개수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("모든 숫자는 1과 45 사이의 값이어야 한다")
    public void RangeTest() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Integer> numbers = generator.generateNumbers();
        assertTrue(numbers.stream().allMatch(number -> number >= 1 && number <= 45), "모든 숫자는 1과 45 사이의 값이어야 합니다.");
    }

    @Test
    @DisplayName("모든 숫자는 중복되지 않아야 한다")
    public void DuplicateTest() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Integer> numbers = generator.generateNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertEquals(numbers.size(), uniqueNumbers.size(), "숫자들 사이에 중복이 있습니다.");
    }

    @Test
    @DisplayName("생성된 숫자 리스트는 정렬되어야 한다")
    public void ListSortingTest() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Integer> numbers = generator.generateNumbers();
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        assertEquals(sortedNumbers, numbers, "리스트가 정렬되지 않았습니다.");
    }
}