package view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createAmountNotNumber() {
        assertSimpleTest(() -> {
            runException("run");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
