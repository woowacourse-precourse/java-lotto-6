package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class InputErrorTest extends NsTest {

    @Test
    @DisplayName("로또 금액에 문자 입력시 예외 처리")
    void numeric_money() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(NUMERIC_ERROR.getMessage());
        });
    }

    @Test
    @DisplayName("로또 금액에 음수 입력시 예외 처리")
    void negative_money() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(NEGATIVE_INT_ERROR.getMessage());
        });
    }

    @Test
    @DisplayName("로또 금액 단위보다 적은 돈 입력시 예외 처리")
    void not_unit_money1() {
        assertSimpleTest(() -> {
            runException("999");
            assertThat(output()).contains(MONEY_UNIT_ERROR.getMessage());
        });
    }

    @Test
    @DisplayName("로또 금액 단위에 맞지 않는 돈 입력시 예외 처리")
    void not_unit_money2() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(MONEY_UNIT_ERROR.getMessage());
        });
    }

    @Test
    @DisplayName("당첨 로또 번호에 쉼표(,)를 제외한 특수문자 입력시 예외 처리")
    void lotto_comma() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5/6");
            assertThat(output()).contains(SPLIT_REGEX_ERROR.getMessage());
        });
    }

    @Test
    @DisplayName("당첨 로또 번호에 문자 입력시 예외 처리")
    void lotto_char() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,a");
            assertThat(output()).contains(NUMERIC_ERROR.getMessage());
        });
    }

    @Test
    @DisplayName("당첨 보너스 번호에 문자 입력시 예외 처리")
    void bonus_number_char() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(NUMERIC_ERROR.getMessage());
        });
    }

    @Test
    @DisplayName("당첨 보너스 번호에 당첨 로또에 있는 번호 입력시 예외 처리")
    void bonus_number_contain() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ALREADY_CONTAINS_ERROR.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
