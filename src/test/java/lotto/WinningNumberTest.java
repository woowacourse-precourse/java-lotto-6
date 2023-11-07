package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest extends ApplicationTest {
    public static final String ERROR_MESSAGE = "[ERROR]";



    @DisplayName("중복예외처리")
    @Test
    void duplicateTest() {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자개수가 6개 보다 적을 때 예외처리")
    @Test
    void lessCountTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("숫자개수가 6개 보다 많을 때 예외처리")
    @Test
    void moreCountTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호가 45 초과일 때")
    @Test
    void outRangeTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
}
