package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.message.ErrorMessage.DIVISIBLE_BY_1000;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_MONEY;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import lotto.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputPurchaseAmountTest extends NsTest {
    Input input = new Input();

    @Test
    @DisplayName("유효한 구입금액 입력 테스트")
    void getValidPurchaseAmount_test() {
        command("8000");

        assertThat(input.getValidPurchaseAmount()).isEqualTo(8000);

    }

    @Test
    @DisplayName("숫자가 아닌 구입금액 입력 시 예외 테스트")
    void validateNonNumericalPurchaseAmount_test() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(NUMBER_FORMAT_MONEY.errorMessage());
        });
    }

    @Test
    @DisplayName("1000원 단위가 아닌 구입금액 입력 시 예외 테스트")
    void validatePurchaseAmountDivisibleBy1000_test() {
        assertSimpleTest(() -> {
            runException("2500");
            assertThat(output()).contains(DIVISIBLE_BY_1000.errorMessage());
        });
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {
        input.getValidPurchaseAmount();
    }
}
