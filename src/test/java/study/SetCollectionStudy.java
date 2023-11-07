package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetCollectionStudy {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set Size 확인")
    void 요구사항1() {
        int size = numbers.size();
        Assertions.assertThat(size).isEqualTo(4);
    }

    @DisplayName("ParameterizedTest 활용")
    @ParameterizedTest
    @ValueSource(ints = {1, 1, 2, 3})
    void 요구사항2(int number) {
        org.junit.jupiter.api.Assertions.assertTrue(numbers.contains(number));

    }

    @DisplayName("ParameterizedTest 활용2")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 요구사항3(int input, boolean expected) {
        Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
