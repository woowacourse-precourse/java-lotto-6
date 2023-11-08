package lotto.global.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.global.util.StringConverter.IntegerListToStringConverter;
import lotto.global.util.StringConverter.StringToIntegerListConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConverterTest {
    StringToIntegerListConverter stringToIntegerListConverter = StringToIntegerListConverter.getInstance();
    IntegerListToStringConverter integerListToStringConverter = IntegerListToStringConverter.getInstance();

    @Test
    @DisplayName("문자열 숫자 리스트로 만들기 성공")
    void convertStringToIntList_success(){
        String from = "1,2,3,4";
        List<Integer> integers = stringToIntegerListConverter.convert(from);
        List<Integer> compareList = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(integers).isEqualTo(compareList);
    }

    @Test
    @DisplayName("문자열이 숫자가 아닐 경우 Exception throw")
    void stringContainNotInteger_fail(){
        String from = "1,a,2,3";
        assertThatThrownBy(() -> stringToIntegerListConverter.convert(from))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("숫자 리스트로 문자열로 만들기 성공")
    void convertIntListToString_success(){
        String compareString = "1,2,3,4";
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        String convert = integerListToStringConverter.convert(integers);
        Assertions.assertThat(convert).isEqualTo(compareString);
    }
}