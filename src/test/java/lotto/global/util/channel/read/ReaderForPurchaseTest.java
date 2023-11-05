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

@DisplayName("구매 금액 입력기 테스트")
class ReaderForPurchaseTest extends NsTest {
    private static final String PROCESS_STOP = "END";

    @DisplayName("빈 값을 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "\n", " ", "  ", "    "
    })
    void Is_Expected_Validation_About_Blank(String invalidAmountInput) {
        assertSimpleTest(() -> {
            runException(
                    invalidAmountInput
            );
            assertThat(output()).contains(GlobalError.BLANK_INPUT_ERROR.getErrorMessage());
        });
    }

    @DisplayName("0만 입력하거나 0으로 시작되는 잘못된 형식의 숫자를 입력 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "00700", "0", "00", "01234567890"
    })
    void Is_Expected_Validation_About_Invalid_Number(String invalidAmountInput) {
        assertSimpleTest(() -> {
            runException(
                    invalidAmountInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_AMOUNT.getErrorMessage());
        });
    }
    @DisplayName("1000보다 작은 숫자를 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "900", "999", "1", "100"
    })
    void Is_Expected_Validation_About_Not_Enough_Money(String invalidAmountInput) {
        assertSimpleTest(() -> {
            runException(
                    invalidAmountInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_AMOUNT.getErrorMessage());
        });
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 숫자를 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "1234", "1000001", "999999", "1234500"
    })
    void Is_Expected_Validation_About_Impossible_Divide(String invalidAmountInput) {
        assertSimpleTest(() -> {
            runException(
                    invalidAmountInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_AMOUNT.getErrorMessage());
        });
    }

    @DisplayName("한글/영어/특수기호를 포함하고 있는 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "ㄱㄴㄷ가나다", "abcABC", ".,/%$#^", "1234567890ㅑㅑ"
    })
    void Is_Expected_Validation_About_Not_Numeric(String invalidAmountInput) {
        assertSimpleTest(() -> {
            runException(
                    invalidAmountInput
            );
            assertThat(output()).contains(GlobalError.NOT_AVAILABLE_INTEGER.getErrorMessage());
        });
    }
    @DisplayName("너무 큰 정수값을 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(
            strings = {
                    "10000000000000000000",
                    "9999999999999999999999999"
            }
    )
    void Is_Expected_Validation_About_Long(String invalidAmountInput) {
        assertSimpleTest(() -> {
            runException(
                    invalidAmountInput
            );
            assertThat(output()).contains(
                    GlobalError.NOT_AVAILABLE_INTEGER.getErrorMessage()
            );
        });
    }

    @DisplayName("올바른 입력값을 입력한 경우")
    @ParameterizedTest(name = "{index} 번째 검사값 = {0}")
    @ValueSource(strings = {
            "1000", "20000", "300000", "100000"
    })
    void Is_Expected_Validation_About_Available(String availableAmountInput) {
        assertSimpleTest(() -> {
            runException(
                availableAmountInput,
                PROCESS_STOP
            );
            // 다음 단계로 넘어갔는지 확인하는 단계
            assertThat(output()).contains(Ask.WINNING_NUMBERS);
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}