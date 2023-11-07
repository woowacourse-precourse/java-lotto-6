package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputServiceTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("입력한 금액이 숫자가 아니면 예외 처리")
    @Test
    void createAmountByNoNumber() {
        assertSimpleTest(() -> {
            runException("1k");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력한 로또 번호가 숫자가 아니면 예외 처리")
    @Test
    void createLottoByNoNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6k");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력한 보너스 번호가 숫자가 아니면 예외 처리")
    @Test
    void createBonusNumberByNoNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "7k");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}