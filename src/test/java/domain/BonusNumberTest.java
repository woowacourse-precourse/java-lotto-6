package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("보너스 번호가 1 ~ 45 숫자가 아니면 예외 처리")
    @Test
    void createBonusNumberByInvalidRange() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "123");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 로또 번호와 중복이면 예외 처리")
    @Test
    void createBonusNumberByDuplicate() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}