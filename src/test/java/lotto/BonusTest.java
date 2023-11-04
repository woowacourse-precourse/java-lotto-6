package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("보너스 번호에 숫자가 아닌 다른 문자열을 입력하면 예외가 발생한다.")
    @Test
    void InputBonusByNotNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, 6", "40,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호의 숫자가 1 ~ 45 범위를 만족하지 않으면 예외가 발생한다.")
    @Test
    void InputBonusByOutOfRangeNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, 6", "50");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 로또 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void InputBonusByDuplicatedNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, 6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
