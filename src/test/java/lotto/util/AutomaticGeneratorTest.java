package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutomaticGeneratorTest {

    @DisplayName("로또 번호는 랜덤한 1 ~ 45 범위의 값을 가진다.")
    @Test
    void generateLottoNumbersMethodRangeTest() {
        List<Integer> numbers = AutomaticGenerator.generateLottoNumbers();
        assertTrue(numbers.stream().allMatch(number -> number >= 1 && number <= 45));
    }

    @DisplayName("로또 번호에는 중복된 값은 없다.")
    @Test
    void generateLottoNumbersMethodUniqueTest() {
        List<Integer> numbers = AutomaticGenerator.generateLottoNumbers();
        assertEquals(numbers.stream().distinct().count(), numbers.size());
    }

    @DisplayName("로또 번호는 오름차순으로 정렬한다.")
    @Test
    void generateLottoNumbersMethodSortTest() {
        List<Integer> numbers = AutomaticGenerator.generateLottoNumbers();
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        assertEquals(numbers, sortedNumbers);
    }

}