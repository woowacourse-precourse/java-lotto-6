package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ViewValidateTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("공백이나 빈 문자열 입력시 예외 발생")
    void testValidateNotSpaceOrEmpty() {
        // given
        String spaceContent = " ";
        String nothingContent = "";
        String content = "123";

        // when & then
        assertThatThrownBy(() -> ViewValidate.validateNotSpaceOrEmpty(spaceContent))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> ViewValidate.validateNotSpaceOrEmpty(nothingContent))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> ViewValidate.validateNotSpaceOrEmpty(content)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("널 입력시 예외 발생")
    void testValidateNotNull() {
        // given
        String nullContent = null;
        String content = "123";

        // when & then
        assertThatThrownBy(() -> ViewValidate.validateNotNull(nullContent))
                .isInstanceOf(NullPointerException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> ViewValidate.validateNotNull(content)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("문자열을 int 정수로 바꿀수 없는 경우 예외 발생")
    void testValidateAndConvertString2Int() {
        // given
        String notNumber = "1@3";
        String number = "123";

        // when
        int result = ViewValidate.validateAndConvertString2Int(number);

        // when & then
        assertThatThrownBy(() -> ViewValidate.validateAndConvertString2Int(notNumber))
                .isInstanceOf(NumberFormatException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThat(result).isEqualTo(123);
    }
}