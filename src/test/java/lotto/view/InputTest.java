package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("1000단위가 아닌 구매 금액을 입력할 경우 예외가 발생한다.")
    @Test
    void enterNotThousandUnit() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void enterNegativeAmount() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("올바른 구입 금액을 입력하면 정수를 반환한다.")
    @Test
    void enterValidAmount() {
        assertSimpleTest(() -> {
            String amountString = "8000";

            command(amountString);

            int expected = 8000;
            assertThat(Input.readTotalPurchasedAmount()).isEqualTo(expected);
        });
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
