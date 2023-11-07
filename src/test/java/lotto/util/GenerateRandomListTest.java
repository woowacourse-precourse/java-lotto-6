package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GenerateRandomListTest {
    @Test
    @DisplayName("리스트의 숫자는 1~45이다.")
    void listNumberRangeTest() {
        List<Integer> numbers = GenerateRandomList.createRandomList();

        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("리스트의 갯수는 6개이다.")
    void createListByNotSixSize() {
        List<Integer> numbers = GenerateRandomList.createRandomList();

        assertThat(numbers.size()).isEqualTo(6);
    }
}