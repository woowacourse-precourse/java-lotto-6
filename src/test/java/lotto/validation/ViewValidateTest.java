package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ViewValidateTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void validateSpaceOrEmpty() {
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
    void validateNull() {
        // given
        String nullContent = null;
        String content = "123";

        // when & then
        assertThatThrownBy(() -> ViewValidate.validateNotNull(nullContent))
                .isInstanceOf(NullPointerException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> ViewValidate.validateNotNull(content)).doesNotThrowAnyException();
    }

    @Test
    void validateString2Integer() {
        // given
        String notNumber = "1@3";
        String number = "123";

        // when & then
        assertThatThrownBy(() -> ViewValidate.validateConvertingString2Int(notNumber))
                .isInstanceOf(NumberFormatException.class).hasMessageContaining(ERROR_MESSAGE);
        assertThatCode(() -> ViewValidate.validateConvertingString2Int(number)).doesNotThrowAnyException();
    }
}