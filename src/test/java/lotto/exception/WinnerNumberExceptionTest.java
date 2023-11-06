package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumberExceptionTest {

    @Test
    @DisplayName("입력으로 숫자가 들어오지 않으면 예외처리")
    void isNumberTest(){
        //given
        String input = "1,2,3,a,5";
        //then
        assertThatThrownBy(() -> new WinnerNumberException().isNumber(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구분자로 쉼표가 들어오지 않으면 예외처리")
    void isCommaTest(){
        //given
        String input = "1.2.3.4.5";
        //then
        assertThatThrownBy(() -> new WinnerNumberException().isComma(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 시 예외처리")
    void isBlankTest(){
        List<Integer> input = Arrays.asList();
        assertThatThrownBy(() -> new WinnerNumberException().isBlank(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수의 범위가 1 미만 45 초과 시 예외처리")
    void isRightRangeTest(){
        List<Integer> input = Arrays.asList(0,30,8);
        assertThatThrownBy(() -> new WinnerNumberException().isRightRange(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 숫자가 6개가 아닐 시 예외처리")
    void isSizeTest(){
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        assertThatThrownBy(() -> new WinnerNumberException().isSize(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 숫자 내부에서 중복된 것이 있으면 예외처리")
    void isDuplicateTest(){
        List<Integer> input = Arrays.asList(1,1,3);
        assertThatThrownBy(() -> new WinnerNumberException().isDuplicate(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

}