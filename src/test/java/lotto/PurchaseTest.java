package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest extends NsTest {

    @Test
    void five_times() {
        assertSimpleTest(() -> {
            run("5000");
            assertThat(output()).contains("5개");
        });
    }

    @Test
    void non_number() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains("숫자를");
        });
    }

    @Test
    void non_1k() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains("1,000원 단위로");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
