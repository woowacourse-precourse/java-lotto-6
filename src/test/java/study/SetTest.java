package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void setUp(){
        // given
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항 1
    @Test
    @DisplayName("set의 크기를 확인합니다.")
    void checkSetSize(){
        // when
        int setSize = numbers.size();

        // then
        assertThat(setSize).isEqualTo(3);
    }

    // 요구사항 2
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set에 모든 value값들이 들어있는지 확인합니다.")
    void checkSetValue(int number){
        assertTrue(numbers.contains(number));
    }

    // 요구사항 3
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"},delimiter = ',')
    void checkRightNumber(int number, boolean expectedResult){
        boolean actualResult = numbers.contains(number);

        assertEquals(actualResult,expectedResult);
    }
}
