package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("금액 예외 테스트")
    @Test
    void getMoneyTest() {
        assertSimpleTest(() -> {
            runException("abc");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("당첨번호 예외 테스트")
    @Test
    void getWinTest() {
        assertSimpleTest(() -> {
            runException("7000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호 예외 테스트")
    @Test
    void getBonusTest() {
        assertSimpleTest(() -> {
            runException("7000", "1,2,3,4,5,6", "100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
