package lotto.global.util.channel.read;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.global.exception.GlobalError;
import lotto.presentation.message.Ask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 입력기 테스트")
class ReaderForWinningLottoTest extends NsTest {

    private static final String AVAILABLE_AMOUNT_INPUT = "8000";
    private static final String PROCESS_STOP = "END";

    @DisplayName("빈 값을 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "\n", " ", "  ", "    "
    })
    void Is_Expected_Validation_About_Blank(String invalidNumbersInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    invalidNumbersInput
            );
            assertThat(output()).contains(GlobalError.BLANK_INPUT_ERROR.getErrorMessage());
        });
    }

    @DisplayName("한글/영어/특수기호를 포함하고 있는 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "a,b,c,d,e,f", "abcABC", ".,/%$#^", "1234567890ㅑㅑ"
    })
    void Is_Expected_Validation_About_Not_Numeric(String invalidNumbersInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    invalidNumbersInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_LOTTO_NUMBERS_PATTERN.getErrorMessage());
        });
    }

    @DisplayName("구분자를 쓰지 않은 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "00700", "0", "00", "01234567890", "8000", "123456"
    })
    void Is_Expected_Validation_About_Invalid_Number(String invalidNumbersInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    invalidNumbersInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_LOTTO_NUMBERS_PATTERN.getErrorMessage());
        });
    }
    @DisplayName("유효한 구분자가 아닌 기호를 쓰는 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "1*2(3)4^5%6", "1/2/3/4/5/6", "1+2+3+4+5+6", "1-2-3-4-5-6", "1&2&3&4&5&6"
    })
    void Is_Expected_Validation_About_Invalid_Separator(String invalidNumbersInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    invalidNumbersInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_LOTTO_NUMBERS_PATTERN.getErrorMessage());
        });
    }

    @DisplayName("유효하지 않은 숫자들 가진 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "1,  2, 3, 4, 5, 66", "11, 22, 33, 44, 55, 66", "0, 1, 2, 3, 4, 5"
    })
    void Is_Expected_Validation_About_Invalid_Name(String invalidNumbersInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    invalidNumbersInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_LOTTO_NUMBER.getErrorMessage());
        });
    }

    @DisplayName("올바른 입력값을 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "1,2,3,4,5,6", "1, 11, 13, 15, 34, 43", "11,22, 26 ,33,44 ,45"
    })
    void Is_Expected_Validation_About_Available(String availableAmountInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    availableAmountInput,
                    PROCESS_STOP
            );
            // 다음 단계로 넘어갔는지 확인하는 단계
            assertThat(output()).contains(Ask.WINNING_BONUS_NUMBER);
        });
    }
    
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}