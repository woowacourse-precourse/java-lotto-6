package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static lotto.WinningNumberTest.ERROR_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest extends ApplicationTest {

    @DisplayName("당첨번호와 중복될 때 예외처리")
    @Test
    void duplicateTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("유효하지않은 값 예외처리")
    @Test
    void invalidTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "1j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("45초과일 때")
    @Test
    void RangeTest() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }



}
