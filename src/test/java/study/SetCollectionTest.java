package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size 메서드로 set 크기 확인하는 테스트")
    public void setSizeTest() {
        //given

        //when

        //then
        final int TEST_SIZE = 3;
        assertThat(numbers.size())
                .isEqualTo(TEST_SIZE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains 메서드로 값의 존재 확인하는 테스트")
    public void containsTest(int number) {
        //given

        //when

        //then
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains 메서드로 값의 참, 거짓 여부에 대한 테스트")
    public void containsExpectedNumberTest(int number, boolean expected) {
        //given

        //when

        //then
        assertThat(numbers.contains(number)).isEqualTo(expected);
        Assertions.assertEquals(numbers.contains(number), expected);
    }
}
