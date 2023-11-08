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

    @DisplayName("로또 구입 금액에 숫자가 아닌 문자를 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "test", "purchase", "String", "@@@", ",,,", "!@#$!@$!", " ", "\n"
    })
    void purchaseByString(String input) {
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

    @DisplayName("당첨 번호가 1~45 사이에 속하지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "0,2,3,4,5,6", "1,2,3,4,5,46", "11,22,33,44,55,66"
    })
    void winningNumOverBoundary(String input) {
        assertSimpleTest(() -> {
            runException(
                    PURCHASE_FEE,
                    input
            );
            assertThat(output()).contains(ErrorStatus.LOTTO_BOUNDARY_ERROR.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
