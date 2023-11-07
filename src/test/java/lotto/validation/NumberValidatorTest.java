package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    @DisplayName("번호가 양의 정수가 아닌 경우 예외를 발생시킨다.")
    void throwExceptionNumberNotPositiveDigit() {
        //given
        String target = "0";
        //when //then
        assertThatThrownBy(() -> NumberValidator.validateNumber(target))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 번호는 양의 정수만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("번호가 양의 정수인 경우 예외를 발생시키지 않는다.")
    void NotThrowExceptionNumberPositiveDigit() {
        //given
        String target = "1";
        //when //then
        assertThatCode(() -> NumberValidator.validateNumber(target))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("번호가 빈 문자열로 이루어진 경우 예외를 발생시킨다.")
    void throwExceptionNumberBlank() {
        //given
        String target = "";
        //when //then
        assertThatThrownBy(() -> NumberValidator.validateNumber(target))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 번호는 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("번호가 공백을 포함한 경우 예외를 발생시킨다.")
    void throwExceptionNumberContainBlank() {
        //given
        String target = "1 ";
        //when //then
        assertThatThrownBy(() -> NumberValidator.validateNumber(target))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 번호는 공백이 포함될 수 없습니다.");
    }
}