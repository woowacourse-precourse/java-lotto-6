package lotto.constants;

import lotto.constants.pattern.InputPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("입력 패턴 상수에 대해")
class InputPatternTest {

    @Test
    @DisplayName("숫자 검증 정규식 상수에 숫자를 입력 안 하면 true를 반환한다.")
    void When_InputNotNumeric_Then_True() {
        //given
        String givenNotNumeric = "pobi";

        //when
        boolean actual = InputPattern.isNotNumeric(givenNotNumeric);

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("숫자 검증 정규식 상수에 숫자를 입력 하면 false를 반환한다.")
    void When_InputNumericThen_False() {
        //given
        String givenNumeric = "123";

        //when
        boolean actual = InputPattern.isNotNumeric(givenNumeric);

        //then
        assertFalse(actual);
    }

    @Test
    @DisplayName("컴마 구분 정규식 상수에 컴마를 구분자로 입력 안하면 true를 반환한다.")
    void When_InputNotDivisionComma_Then_True() {
        //given
        String givenNotDivisionComma = "1/2/3";

        //when
        boolean actual = InputPattern.isNotDivisionComma(givenNotDivisionComma);

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("컴마 구분 정규식 상수에 문자열을 입력하면 true를 반환한다.")
    void When_InputTestInDivisionComma_Then_True() {
        //given
        String givenDivisionComma = "pobi";

        //when
        boolean actual = InputPattern.isNotDivisionComma(givenDivisionComma);

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("컴마 구분 정규식 상수에 컴마를 구분자로 입력 하면 false를 반환한다.")
    void When_InputDivisionComma_Then_False() {
        //given
        String givenDivisionComma = "1,2,3";

        //when
        boolean actual = InputPattern.isNotDivisionComma(givenDivisionComma);

        //then
        assertFalse(actual);
    }
}
