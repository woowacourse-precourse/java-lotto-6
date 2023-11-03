package lotto.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("입력 패턴 상수에 대해")
class InputPatternTest {

    @Test
    @DisplayName("숫자 검증 정규식 장수에 숫자를 입력 안 하면 true를 반환한다.")
    void When_InputNotNumeric_Then_True() {
        //given
        String givenNumeric = "pobi";

        //when
        boolean isNotNumeric = InputPattern.isNotNumeric(givenNumeric);

        //then
        assertTrue(isNotNumeric);
    }

    @Test
    @DisplayName("숫자 검증 정규식 장수에 숫자를 입력 하면 false를 반환한다.")
    void When_InputNumericThen_False() {
        //given
        String givenNumeric = "123";

        //when
        boolean isNotNumeric = InputPattern.isNotNumeric(givenNumeric);

        //then
        assertFalse(isNotNumeric);
    }
}
