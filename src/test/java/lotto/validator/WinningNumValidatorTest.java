package lotto.validator;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.DUPLICATED_NUMBER;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ExceptionMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumValidatorTest {
    @DisplayName("[당첨 번호 입력 검증] 공백을 입력한 경우")
    @Test
    void validateWinningNumTest1() {
        //given
        String text = "";
        // then
        Assertions.assertThatThrownBy(() -> WinningNumValidator.validateWinningNums(text))
                .hasMessage(CATCH_ERROR + INPUT_EMPTY);
    }

    @DisplayName("[당첨 번호 입력 검증] 숫자가 중복된 경우")
    @Test
    void validateWinningNumTest2() {
        //given
        String text = "1,2,2,3,4,5";
        // then
        Assertions.assertThatThrownBy(() -> WinningNumValidator.validateWinningNums(text))
                .hasMessage(CATCH_ERROR + DUPLICATED_NUMBER);
    }

}