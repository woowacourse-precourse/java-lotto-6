package lotto.integration;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.common.exception.ErrorMessage;
import lotto.config.IntegrationTest;
import lotto.util.InputValidator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExceptionTest extends IntegrationTest {
    private void exceptionTestTemplate(String errorMessage, String... args) {
        assertSimpleTest(() -> {
            runException(args);
            assertThat(output()).contains(ERROR_MESSAGE, errorMessage);
        });
    }

    @Nested
    class 입력값에_문자가없는경우_예외가발생한다 {
        @Test
        void 구매금액_입력값에_문자가없는경우() {
            exceptionTestTemplate(InputValidator.BLANK_INPUT_ERROR_MESSAGE, " ");
        }

        @Test
        void 당첨로또번호_입력값에_문자가없는경우() {
            exceptionTestTemplate(InputValidator.BLANK_INPUT_ERROR_MESSAGE, "5000", " ");
        }

        @Test
        void 보너스볼번호_입력값에_문자가없는경우() {
            exceptionTestTemplate(InputValidator.BLANK_INPUT_ERROR_MESSAGE, "5000", "1,2,3,4,5,6", " ");
        }
    }

    @Nested
    class 입력값에_숫자이외문자가_있다면_예외가발생한다 {
        @Test
        void 구매금액_입력값에_숫자이외문자가_있는_경우() {
            exceptionTestTemplate(InputValidator.INVALID_NUMERIC_INPUT_ERROR_MESSAGE, "100j");
        }

        @Test
        void 당첨로또번호_입력값에_숫자이외문자가_있는_경우() {
            exceptionTestTemplate(InputValidator.INVALID_NUMERIC_INPUT_ERROR_MESSAGE, "5000", "1,2,3a,5,6,7");
        }

        @Test
        void 보너스볼번호_입력값에_숫자이외문자가_있는_경우() {
            exceptionTestTemplate(InputValidator.INVALID_NUMERIC_INPUT_ERROR_MESSAGE, "5000", "1,2,3,4,5,6", "4a");
        }
    }

    @Nested
    class 유효하지않은길이의_입력값이라면_예외가발생한다 {
        @ValueSource(strings = {"1000000000"})
        @ParameterizedTest
        void 구매금액_입력값길이가_유효하지않은_경우(String input) {
            exceptionTestTemplate(InputValidator.INVALID_LENGTH_INPUT_ERROR_MESSAGE, input);
        }

        @ValueSource(strings = {"123,134,12,14,15,16"})
        @ParameterizedTest
        void 당첨로또번호_입력값길이가_유효하지않은_경우(String input) {
            exceptionTestTemplate(InputValidator.INVALID_LENGTH_INPUT_ERROR_MESSAGE, "5000", input);
        }

        @ValueSource(strings = {"123"})
        @ParameterizedTest
        void 보너스볼번호_입력값길이가_유효하지않은_경우(String input) {
            exceptionTestTemplate(InputValidator.INVALID_LENGTH_INPUT_ERROR_MESSAGE, "5000", "1,2,3,4,5,6", input);
        }
    }

    @Nested
    class 구매금액_입력시_예외가발생한다 {
        @ValueSource(strings = {"999", "100000001"})
        @ParameterizedTest
        void 구매금액이_1000원이상_100_000_000원이하가_아니라면(String input) {
            exceptionTestTemplate(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getValue(), input);
        }

        @ValueSource(strings = {"1001", "10000999"})
        @ParameterizedTest
        void 구매금액이_1000원단위가_아니라면(String input) {
            exceptionTestTemplate(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getValue(), input);
        }
    }

    @Nested
    class 당첨로또번호_입력시_예외가발생한다 {
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        @ParameterizedTest
        void 로또번호길이가_6이_아니라면(String input) {
            exceptionTestTemplate(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getValue(), "5000", input);
        }

        @ValueSource(strings = {"1,2,3,4,5,0", "1,2,3,46,5,6"})
        @ParameterizedTest
        void 로또번호가_1이상45이하가_아니라면(String input) {
            exceptionTestTemplate(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getValue(), "5000", input);
        }

        @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,2,6"})
        @ParameterizedTest
        void 로또번호에_중복이_있다면(String input) {
            exceptionTestTemplate(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getValue(), "5000", input);
        }
    }

    @Nested
    class 보너스볼번호_입력시_예외가발생한다 {
        @ValueSource(strings = {"0", "46"})
        @ParameterizedTest
        void 입력이_1이상45이하가_아니라면(String input) {
            exceptionTestTemplate(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getValue(), "5000", "1,2,3,4,5,6", input);
        }

        @ValueSource(strings = {"6"})
        @ParameterizedTest
        void 보너스볼번호가_당첨로또번호와_중복된다면(String input) {
            exceptionTestTemplate(ErrorMessage.DUPLICATED_WINNING_LOTTO_NUMBER_AND_BONUS_BALL.getValue(), "5000",
                    "1,2,3,4,5,6", input);
        }
    }
}
