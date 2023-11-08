package lotto.utilTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TypeConvertorTest {

    @DisplayName("List의 size와 String의 숫자 개수가 동일해야 함")
    @Test
    void whenConvertStringToIntegerList_thenEqualTheSize() {
        String testInput = "1,2,3,4,5,6";
        List<Integer> integers = TypeConvertor.stringToIntegerList(testInput);

        assertThat(integers.size()).isEqualTo(6);
    }
    @DisplayName("변환된 List는 Integer List와 동일해야 함")
    @Test
    void shouldEqualWithIntegerList() {
        String testInput = "1, 2 , 3 ,4,5, 6";
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> convertedList = TypeConvertor.stringToIntegerList(testInput);
        assertThat(convertedList).isEqualTo(integers);
    }

    @DisplayName("변환된 List의 각 요소는 Integer 타입이어야 함")
    @Test
    void shouldEachComponentShouldBeIntegerType() {
        String testInput = "1, 2 , 3 ,4,5, 6,";
        List<Integer> integers = TypeConvertor.stringToIntegerList(testInput);

        integers.stream().forEach(a -> assertThat(a).isInstanceOf(Integer.class));
    }

    @DisplayName("String에 공백이 불규칙하게 존재해도 동일하게 List로 변환되어야 함")
    @Test
    void shouldReturnCorrectList_fromDifferentSpaceInString() {
        String testInput = " 1, 2 ,3 ,4, 5, 6 ";
        List<Integer> integers = TypeConvertor.stringToIntegerList(testInput);

        assertThat(integers.size()).isEqualTo(6);
    }

    @DisplayName("문자열 뒤에 콤마(,)와 공백이 있어도 동일하게 List로 변환되어야 함")
    @Test
    void shouldReturnCorrectList_fromCommaEndString() {
        String testInput = " 1, 2 ,3 ,4, 5, 6, ";
        List<Integer> integers = TypeConvertor.stringToIntegerList(testInput);

        assertThat(integers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호에 정수가 아닌 값이 들어있을 경우 exception")
    @Test
    void shouldThrowIllegalArgumentException() {
        String testInput = "1,2,j,4,5,6";
        assertThatThrownBy(() -> TypeConvertor.stringToIntegerList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호에 정수가 아닌 값이 들어있습니다");
    }

}
