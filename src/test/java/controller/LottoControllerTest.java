package controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import type.TextType;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest extends NsTest {
    private LottoController lottoController;
    private static final String ERROR_MESSAGE = "[ERROR]";


    @BeforeEach
    void setUp() {
        lottoController = new LottoController();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAAAAA", "AA", "AAA"})
    void 금액_문자_입력_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "\r", "\r\n"})
    void 금액_공백_입력_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"8000, 8", "2000, 2", "16000, 16"})
    void 금액_정상_입력_테스트(String money, String count) {
        assertSimpleTest(
                () -> {
                    runException(money, count);
                    assertThat(output()).contains(count + TextType.PRICE_TO_NUMBER.getText());
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1", "\n", "1,2,3,4,5,6,7"})
    void 당첨_번호_길이_입력_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException("5000", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {",,,,,,", "1/2/3/4/5/6", "1.2.3.4.5.6", "1?2?3,4?5,6"})
    void 당첨_번호_특수_입력_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException("5000", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "4,5,6,7,8,9"})
    void 당첨_번호_정상_입력_테스트(String input) {
        assertSimpleTest(
                () -> {
                    runException("5000", input);
                    assertThat(output()).contains(TextType.LOTTO_BONUS.getText());
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "A"})
    void 보너스_번호_입력_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "46", "0"})
    void 보너스_번호_중복_범위_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"7", "45", "1"})
    void 보너스_번호_정상_입력_테스트(String input) {
        assertSimpleTest(() -> {
            runException("5000", "9,2,3,4,5,6", input);
            assertThat(output()).contains(TextType.WINNING_STATISTICS.getText());
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}