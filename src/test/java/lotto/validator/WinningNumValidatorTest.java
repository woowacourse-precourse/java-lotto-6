package lotto.validator;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ExceptionMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumValidatorTest {
    @DisplayName("공백을 입력한 경우")
    @Test
    void 공백_입력한_경우() {
        //given
        String text = "";
        // then
        Assertions.assertThatThrownBy(() -> WinningNumValidator.validateWinningNums(text))
                .hasMessage(CATCH_ERROR + INPUT_EMPTY);
    }

}