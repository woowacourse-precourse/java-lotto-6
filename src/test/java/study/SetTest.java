package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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

    @DisplayName("요구사항 1 : Set의 size 확인하는 메소드")
    @Test
    void size_Set의_크기는_3개입니다(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    //parameterized Test 활용
    @ParameterizedTest
    @DisplayName("요구사항 2 : Set의 contains 확인하는 메소드")
    @ValueSource(ints = {1,2,3})
    void contains_Set은_1_2_3을_가지고_있다(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항 3 : CsvSource 를 이용한 ParameterizedTest 구현")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_Set은_123_은_갖고_있고_45는_갖고있지_않다(int number, boolean contain){
        assertThat(numbers.contains(number)).isEqualTo(contain);
    }


}
