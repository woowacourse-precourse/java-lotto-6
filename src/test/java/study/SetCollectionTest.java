package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //요구사항1
    @Test
    @DisplayName("Set Collection의 size 메서드 테스트")
    public void Set_크기_구하기_메서드_테스트() {
        //when
        Integer size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    //요구사항2
    @ParameterizedTest
    @DisplayName("Set의 contains() 메서드 테스트")
    @ValueSource(ints = {1, 2, 3})
    public void Set_Contain_메서드_테스트(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    //요구사항3
    @ParameterizedTest
    @DisplayName("Set의 contains() 메서드 테스트")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void Set_Contain_메서드_통합_테스트(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}