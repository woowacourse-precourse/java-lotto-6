package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ErrorApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구매하기위한 로또 금액이 천원으로 나누어 떨어지지 않는 경우 예외 발생.")
    @Test
    void priceRemainExceptionTest() {
        assertSimpleTest(() -> {
            runException("5001", "1,2,3,4,5,6","7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호가 1~45 사이가 아닌 경우 예외 발생.")
    @Test
    void numberRangeExceptionTest() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,50", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 로또 번호가 총 6개가 아닌 경우 예외 발생.")
    @Test
    void numberSizeExceptionTest() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 로또 번호와 보너스 번호가 중복되는 경우 예외 발생.")
    @Test
    void bonusDuplicateExceptionTest() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
