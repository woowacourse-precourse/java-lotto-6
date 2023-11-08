package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class studyJUnit {

    // String 클래스의 toLowerCase() 메소드를 테스트하는 파라미터화된 테스트
    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertEquals(expected, actualValue);
    }

    // Set의 contains() 메소드를 테스트하는 파라미터화된 테스트
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContains_ShouldReturnTrueForExistingValues(int value) {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3));
        assertTrue(numbers.contains(value));
    }

    // String의 charAt() 메소드를 테스트하는 테스트
    @Test
    @DisplayName("charAt 메소드는 주어진 위치의 문자를 반환해야 한다")
    void charAt_ShouldReturnTheCharacterAtTheSpecifiedIndex() {
        String str = "abc";
        assertEquals('a', str.charAt(0));
        assertEquals('b', str.charAt(1));
        assertEquals('c', str.charAt(2));
    }

    // String의 charAt() 메소드가 범위를 벗어날 때 예외를 테스트하는 테스트
    @Test
    @DisplayName("charAt 메소드는 위치 값이 범위를 벗어나면 StringIndexOutOfBoundsException을 발생시켜야 한다")
    void charAt_ShouldThrowStringIndexOutOfBoundsExceptionWhenIndexIsOutOfBounds() {
        String str = "abc";
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            str.charAt(3); // 인덱스 3은 문자열 "abc"의 범위를 벗어남
        });
    }
}
