package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자들 객체에 대해")
class NumbersTest {

    @ParameterizedTest
    @MethodSource("numberValuesSource")
    @DisplayName("각 숫자들을 Number 객체들로 저장한다.")
    void Given_CreateNumbers_When_GetNumberValues_Then_InstanceOfNumber(List<Integer> value) {
        //given
        Numbers numbers = new Numbers(value);

        //when
        List<Number> numberValues = numbers.getValues();

        //then
        numberValues.forEach(number -> assertThat(number).isInstanceOf(Number.class));
    }

    @ParameterizedTest
    @MethodSource("numberValuesSource")
    @DisplayName("각 숫자들의 개수와 일치하게 저장한다.")
    void Given_CreateNumbers_When_GetNumberValues_Then_EqualSize(List<Integer> value) {
        //given
        Numbers numbers = new Numbers(value);

        //when
        List<Number> numberValues = numbers.getValues();

        //then
        assertThat(numberValues).hasSize(6);
    }

    static Stream<List<Integer>> numberValuesSource() {
        return Stream.of(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("각 숫자들이 오름차순 정렬되어 저장된다.")
    void Given_CreateNumbers_When_GetNumberValues_Then_NumbersAsc() {
        //given
        Numbers numbers = new Numbers(List.of(43, 42, 41, 23, 22, 8));

        //when
        List<Number> numberValues = numbers.getValues();
        List<Integer> numbersAsc = numberValues.stream()
                .map(Number::getValue)
                .toList();

        //then
        assertThat(numbersAsc).isEqualTo(List.of(8, 22, 23, 41, 42, 43));
    }

}
