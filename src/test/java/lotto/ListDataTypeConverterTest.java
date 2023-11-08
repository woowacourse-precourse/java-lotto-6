package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListDataTypeConverterTest {

    @Test
    @DisplayName("List 데이터 타입이 Integer -> String으로 변경된다.")
    void convertListDataTypeIntegerToString() {
        //given
        List<Integer> integers = List.of(1,2,3,4);

        //when
        List<String> strings = ListDataTypeConverter.integerToString(integers);

        //then
        Assertions.assertTrue(strings.stream().allMatch(item -> item instanceof String));
    }

    @Test
    @DisplayName(("List 데이터 타입을 String -> Integer로 변경 할때 문자열이 숫자로만 이루어져 있지 않으면 예외가 발생한다."))
    void convertListDataTypeStringToIntegerNotMadeNumberException() {
        //given
        List<String> strings = List.of("1000","1000j","044");

        //when && then
        assertThatThrownBy(() -> ListDataTypeConverter.stringToInteger(strings)).isInstanceOf(
                NumberFormatException.class)
            .hasMessage("변환 하려는 문자열이 숫자로만 이루어져 있지 않습니다.");
    }

    @Test
    @DisplayName(("List 데이터 타입을 String -> Integer로 변경 할때 문자열이 숫자로만 이루어져 있을 경우 Integer 리스트로 변환된다."))
    void convertListDataTypeStringToInteger() {
        //given
        List<String> strings = List.of("1000","1000","044");

        //when
        List<Integer> integers = ListDataTypeConverter.stringToInteger(strings);

        //then
        Assertions.assertTrue(integers.stream().allMatch(item -> item instanceof Integer));
    }
}