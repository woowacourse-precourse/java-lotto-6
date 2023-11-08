package lotto.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void testGenerateUniqueNumbers() {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> numbers = generator.generateUniqueNumbers();

        assertEquals(6, numbers.size(), "생성된 숫자들의 개수가 6개가 아님");

        assertEquals(6, Set.copyOf(numbers).size(), "중복된 숫자가 있음");

        assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 45), "숫자가 1과 45 사이에 있지 않음");
    }
}