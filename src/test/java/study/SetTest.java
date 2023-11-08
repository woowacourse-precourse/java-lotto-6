package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set.size(): Set은 중복을 허용하지 않는다")
    void givenNumbers_whenSize_thenReturnThree() {
        int result = numbers.size();

        assertNotEquals(4, result);
        assertEquals(3, result);
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set.contains(): Set에 값이 존재하면 true 반환")
    void givenNumbers_whenContains_thenReturnTrue(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest(name = "입력값 : {0}, 결과 : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set.contains(): Set에 값이 존재하면 true, 존재하지 않으면 false 반환")
    void givenNumbers_whenContains_thenReturnTrueOrFalse(int number, boolean expected) {
        assertEquals(expected, numbers.contains(number));
    }

}
