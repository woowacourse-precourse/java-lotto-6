package lotto.validation;

import static lotto.validation.InputValidation.validateInput;
import static lotto.view.ErrorMessage.ILLEGAL_MONEY;
import static lotto.view.SystemMessage.ASK_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.SystemMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {
    @DisplayName("입력 유효성 검사: 구입 금액 관련 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", "a123", "123a", "1as123", "  123", "123   ", "999", "0", "123",
            "500", "1999", "41234", "2312", "6500", "2147483648"})
    void 예외테스트_validateInput_구입금액(String input) {
        //given
        SystemMessage systemMessage = ASK_MONEY;

        assertThatThrownBy(() -> validateInput(systemMessage, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_MONEY.getMessage());
    }

    @DisplayName("입력 유효성 검사: 구입 금액 관련 통과 처리")
    @ParameterizedTest
    @ValueSource(strings = {"5000", "10000", "2000000000"})
    void 통과테스트_validateInput_구입금액(String input) {
        //given
        SystemMessage systemMessage = ASK_MONEY;
        //when
        boolean result = validateInput(systemMessage, input);
        //then
        assertThat(result).isTrue();
    }
}
