package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    @DisplayName("주어진 범위의 중복되지 않은 숫자 리스트 생성 후 반환")
    void createUniqueNumbers() {
        //given
        int min = 1;
        int max = 45;
        int size = 6;
        RandomGenerator generator = new RandomGenerator();

        //when
        List<Integer> numbers = generator.createUniqueNumbers(min, max, size);

        //then
        assertThat(numbers.size()).isEqualTo(size);
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        assertThat(numberSet.size()).isEqualTo(size);
        assertThat(Collections.max(numbers)).isLessThanOrEqualTo(max);
        assertThat(Collections.min(numbers)).isGreaterThanOrEqualTo(min);
    }
}