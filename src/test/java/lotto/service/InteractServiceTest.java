package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Enum.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InteractServiceTest extends NsTest {

    private final String PURCHASE_FEE = "8000";
    private final String LOTTO_NUM = "1,2,3,4,5,6";
    private final String BONUS_NUM = "7";

    @DisplayName("로또 구입 금액을 문자열로 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "test", "purchase", "String"
    })
    void purchaseByString(String input) {
        assertSimpleTest(() -> {
            runException(
                    input
            );
            assertThat(output()).contains(ErrorStatus.PARSE_INT_ERROR.getMessage());
        });
    }

    @DisplayName("로또 구입 금액을 기호로 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "@@@", ",,,", "!@#$!@$!"
    })
    void purchaseBySign(String input) {
        assertSimpleTest(() -> {
            runException(
                    input
            );
            assertThat(output()).contains(ErrorStatus.PARSE_INT_ERROR.getMessage());
        });
    }

    @DisplayName("로또 구입 금액을 공백로 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            " ", "\n"
    })
    void purchaseByBlank(String input) {
        assertSimpleTest(() -> {
            runException(
                    input
            );
            assertThat(output()).contains(ErrorStatus.PARSE_INT_ERROR.getMessage());
        });
    }

    @DisplayName("로또 구입 금액을 음수로 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "-400", "-800", "-1200"
    })
    void purchaseByNegative(String input) {
        assertSimpleTest(() -> {
            runException(
                    input
            );
            assertThat(output()).contains(ErrorStatus.NEGATIVE_INPUT_ERROR.getMessage());
        });
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "500", "1200", "9999"
    })
    void purchaseNotDivideByThousand(String input) {
        assertSimpleTest(() -> {
            runException(
                    input
            );
            assertThat(output()).contains(ErrorStatus.NOT_DIVISION_THOUSAND_ERROR.getMessage());
        });
    }

    @DisplayName("당첨 번호에 숫자가 아닌 문자를 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,ss,tt", "1,2,3, ,5,6", "1,2,@@,4,5,6", "1,2,3,4,\n,6"
    })
    void winningNumByString(String input) {
        assertSimpleTest(() -> {
            runException(
                    PURCHASE_FEE,
                    input
            );
            assertThat(output()).contains(ErrorStatus.PARSE_INT_ERROR.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
