package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputDeviceTest extends NsTest {

    @Test
    void 로또_구입_금액_1() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        });
    }

    @Test
    void 로또_구입_금액_2() {
        assertSimpleTest(() -> {
            runException("j");
            assertThat(output()).contains(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        });
    }

    @Test
    void 로또_구입_금액_3() {
        assertSimpleTest(() -> {
            runException("1000 ");
            assertThat(output()).contains(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        });

        assertSimpleTest(() -> {
            runException(" 1000");
            assertThat(output()).contains(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
