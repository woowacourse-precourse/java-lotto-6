package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 번호가 6개가 아니면 예외 처리")
    @Test
    void createLottoByOverSize() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호가 1 ~ 45 숫자가 아니면 예외 처리")
    @Test
    void createLottoByInvalidRange() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,123");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호가 중복 이면 예외 처리")
    @Test
    void createLottoByDuplicate() {
        assertSimpleTest(() -> {
            runException("1000", "1,1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}