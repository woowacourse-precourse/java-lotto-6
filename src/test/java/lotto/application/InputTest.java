package lotto.application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.config.TestConfig;
import lotto.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[통합 테스트] 입력 기능 테스트")
class InputTest extends NsTest {

    private static final String FIRST_VALID_INPUT = "1000";
    private static final String SECOND_VALID_INPUT = "1,2,3,4,5,6";

    @ParameterizedTest
    @ValueSource(strings = {"1000   ", " 2000 ", "    3000    ", "4000"})
    void 첫번째_정상_입력_값_테스트(String input) {
        assertSimpleTest(() -> runException(input));
        assertThat(output()).doesNotContain(TestConfig.ERROR_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2 ,3,4,5,6", "  1,  2  ,  3  ,  4  ,  5  ,  6"})
    void 두번째_정상_입력_값_테스트(String secondInput) {
        assertSimpleTest(() -> runException(FIRST_VALID_INPUT, secondInput));
        assertThat(output()).doesNotContain(TestConfig.ERROR_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7  ", " 7 ", "    7"})
    void 세번째_정상_입력_값_테스트(String thirdInput) {
        assertSimpleTest(() -> runException(FIRST_VALID_INPUT, SECOND_VALID_INPUT, thirdInput));
        assertThat(output()).doesNotContain(TestConfig.ERROR_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "      ", "\n", "\r\n", "\r", "\t"})
    void 공백_입력_값_예외_테스트(String input) {
        assertSimpleTest(() -> runException(input));
        assertThat(output()).contains(TestConfig.ERROR_MESSAGE_PREFIX)
                .contains(InputException.INVALID_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "한국어", "#"})
    void 문자열_입력_값_예외_테스트(String input) {
        assertSimpleTest(() -> runException(input));
        assertThat(output()).contains(TestConfig.ERROR_MESSAGE_PREFIX)
                .contains(InputException.INVALID_INTEGER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ,  ", "1,2,3,,4,5", "1,2,3,4,5,1 6"})
    void 쉼표_기준_공백_입력_값_예외_테스트(String secondInput) {
        assertSimpleTest(() -> runException(FIRST_VALID_INPUT, secondInput));
        assertThat(output()).contains(TestConfig.ERROR_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "1;2;3;4;5;6"})
    void 구분자_예외_테스트(String secondInput) {
        assertSimpleTest(() -> runException(FIRST_VALID_INPUT, secondInput));
        assertThat(output()).contains(TestConfig.ERROR_MESSAGE_PREFIX)
                .contains(InputException.INVALID_DELIMITER.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
