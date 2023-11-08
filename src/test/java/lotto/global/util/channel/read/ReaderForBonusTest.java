package lotto.global.util.channel.read;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.global.exception.GlobalError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

@DisplayName("보너스 번호 입력기 테스트")
class ReaderForBonusTest extends NsTest {

    private static final String AVAILABLE_AMOUNT_INPUT = "8000";
    private static final String AVAILABLE_WINNING_LOTTO_NUMBERS_INPUT = "1,2,3,4,5,6";

    @DisplayName("빈 값을 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "\n", " ", "  ", "    "
    })
    void Is_Expected_Validation_About_Blank(String invalidBonusNumberInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    AVAILABLE_WINNING_LOTTO_NUMBERS_INPUT,
                    invalidBonusNumberInput
            );
            assertThat(output()).contains(GlobalError.BLANK_INPUT_ERROR.getErrorMessage());
        });
    }

    @DisplayName("한글/영어/특수기호를 포함하고 있는 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "ㄱㄴㄷ가나다", "abcABC", ".,/%$#^", "1234567890ㅑㅑ"
    })
    void Is_Expected_Validation_About_Not_Numeric(String invalidBonusNumberInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    AVAILABLE_WINNING_LOTTO_NUMBERS_INPUT,
                    invalidBonusNumberInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_INTEGER.getErrorMessage());
        });
    }

    @DisplayName("0만 입력하거나 0으로 시작되는 잘못된 형식의 숫자를 입력 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "00700", "0", "00", "01234567890"
    })
    void Is_Expected_Validation_About_Invalid_Number(String invalidBonusNumberInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    AVAILABLE_WINNING_LOTTO_NUMBERS_INPUT,
                    invalidBonusNumberInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_LOTTO_NUMBER.getErrorMessage());
        });
    }

    @DisplayName("유효하지 않은 로또 번호를 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "46", "-1", "99", "1234567890"
    })
    void Is_Expected_Validation_About_Invalid_Lotto_Number(String invalidBonusNumberInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    AVAILABLE_WINNING_LOTTO_NUMBERS_INPUT,
                    invalidBonusNumberInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_LOTTO_NUMBER.getErrorMessage());
        });
    }

    @DisplayName("당첨 로또 번호 중 하나와 동일한 번호를 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "1", "2", "3", "4", "5", "6"
    })
    void Is_Expected_Validation_About_Alredy_Exist_In_Winning_Number(String invalidBonusNumberInput) {
        assertSimpleTest(() -> {
            runException(
                    AVAILABLE_AMOUNT_INPUT,
                    AVAILABLE_WINNING_LOTTO_NUMBERS_INPUT,
                    invalidBonusNumberInput
            );
            assertThat(output()).contains(GlobalError.ALREADY_EXIST_IN_WINNING_NUMBERS.getErrorMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}