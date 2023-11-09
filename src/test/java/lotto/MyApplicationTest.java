package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "100"})
    void 구입_금액_입력_예외_테스트(String budget) {
        assertSimpleTest(() -> {
            runException(budget);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "0,1,2,3,4,5", "1,2,3,4,5"})
    void 당첨_번호_입력_예외_테스트(String winningNumbers) {
        String budget = "1000";
        assertSimpleTest(() -> {
            runException(budget, winningNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "46", "@"})
    void 보너스_번호_입력_예외_테스트(String budget) {
        assertSimpleTest(() -> {
            runException(budget);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
