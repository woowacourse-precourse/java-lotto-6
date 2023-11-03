package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @DisplayName("문자열을 입력받고 정수로 바꿔서 반환한다")
    @Test
    void parseIntTest() {
        //given
        String number = "1";
        //when
        int parseInt = StringUtil.parseInt(number);
        //then
        Assertions.assertEquals(1, parseInt);
    }

    @DisplayName("입력받은 문자열이 정수가 아니거나 , 빈값인 경우 에러를 발생시킨다")
    @Test
    void parseIntNoIntegerTest() {
        //given
        String blank1 = "";
        String blank2 = " ";
        String floatValue = "0.1";

        //when,then
        assertThatThrownBy(() -> StringUtil.parseInt(blank1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringUtil.parseInt(blank2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringUtil.parseInt(floatValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 입력받고 , 기준으로 나누고 List<Integer>의 형태로 반환해준다")
    @Test
    void parseCommaTest() {
        //given
        String commaString = "1,2,3,4,5,6";
        //when
        List<Integer> parseString = StringUtil.parseComma(commaString);
        //then
        Assertions.assertEquals(parseString.toString(), List.of(1, 2, 3, 4, 5, 6).toString());
    }

    @DisplayName("입력받은 문자열의 값이 정수가 아니거니 , 빈값인경우 에러를 발생시킨다")
    @Test
    void parseCommaBlankTest() {
        //given
        String blank1 = "";
        String blank2 = "1, ";
        String blank3 = "1,";
        String noInteger = "a";

        //when,then
        assertThatThrownBy(() -> StringUtil.parseInt(blank1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringUtil.parseInt(blank2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringUtil.parseInt(blank3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> StringUtil.parseInt(noInteger))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
