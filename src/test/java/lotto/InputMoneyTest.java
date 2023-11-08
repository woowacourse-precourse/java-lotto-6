package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputMoneyTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 구입금액 입력 기능
    @Test
    void 예외_테스트_빈칸_입력(){
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_숫자_외_입력(){
        assertSimpleTest(() -> {
            runException("$10000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_음수_입력(){
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_최소_금액_미만_입력(){
        assertSimpleTest(() -> {
            runException("999");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_거스름돈_존재(){
        assertSimpleTest(() -> {
            runException("1004");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}