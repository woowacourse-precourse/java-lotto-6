package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class CustomApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("사용자가 입력한 로또 당첨 번호에 중복된 숫자가 포함되면 예외가 발생한다.")
    @Test
    void inputWinningNumberByDuplication() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,1,2,3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
