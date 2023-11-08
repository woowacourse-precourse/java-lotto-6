package lotto.util;

import lotto.util.validator.InputValidator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private static final String ERROR_CODE = "[ERROR]";
    private static final int MEMORY_SIZE_LIMIT = 2100000000;

    InputValidator inputValidator = new InputValidator();

    @Test
    void 적당한_사이즈의_숫자를_입력하면_정상_작동() {
        String numberString = "14000";

        assertThat(inputValidator.parseValidatedInt(numberString))
                .isEqualTo(14000);
    }

    @Test
    void 숫자가_아닌_기호를_검증_시도하면_IllegalArgumentException_발생() {
        String notNumberString = "숫자가 아니다.";

        assertThatThrownBy(() -> inputValidator.parseValidatedInt(notNumberString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null을_검증_시도하면_IllegalArgumentException_발생() {
        String blank = "";

        assertThatThrownBy(() -> inputValidator.parseValidatedInt(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputValidator.parseValidatedInt(blank))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이십일억보다_큰_숫자를_입력하면_예외를_발생한다() {
        String tooLargeNumberString = String.valueOf(MEMORY_SIZE_LIMIT);

        assertThatThrownBy(() -> inputValidator.parseValidatedInt(tooLargeNumberString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호를_입력받을_때_쉼표를_기준으로_숫자를_변환해서_리스트에_저장한다() {
        String numbersMessage = "1,2,3,4,5,6";
        assertThat(inputValidator.validateWinNumbers(numbersMessage))
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨번호를_입력받을_때__공백도_제거해서_숫자만을_리스트에_저장한다() {
        String numbersMessage = "     1       ,      2     ,      3      ,      4      ,    5   ,    6";
        assertThat(inputValidator.validateWinNumbers(numbersMessage))
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨번호를_입력받을_때_쉼표_사이의_공백을_입력받을_경우_IllegalArgumentException_발생() {
        String numbersMessage = "1,,3,4,5,6";
        assertThatThrownBy(() -> inputValidator.validateWinNumbers(numbersMessage))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 검증_실패시_오류코드를_포함한_에러_메시지_발생() {
        String notNumberString = "숫자가 아니다.";
        assertThatThrownBy(() -> inputValidator.parseValidatedInt(notNumberString))
                .hasMessageContaining(ERROR_CODE);

        String tooLargeNumberString = String.valueOf(MEMORY_SIZE_LIMIT);
        assertThatThrownBy(() -> inputValidator.parseValidatedInt(tooLargeNumberString))
                .hasMessageContaining(ERROR_CODE);

        assertThatThrownBy(() -> inputValidator.parseValidatedInt(null))
                .hasMessageContaining(ERROR_CODE);

        String blank = "";
        assertThatThrownBy(() -> inputValidator.parseValidatedInt(blank))
                .hasMessageContaining(ERROR_CODE);

        String numbersMessage = "1,,3,4,5,6";
        assertThatThrownBy(() -> inputValidator.validateWinNumbers(numbersMessage))
                .hasMessageContaining(ERROR_CODE);
    }
}