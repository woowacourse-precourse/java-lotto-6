package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.receiveWinningNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void testGetLottoPurchasePrice() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void testReceiveWinningNumbers() {
        String input = "1,2,3,4,5";
        int[] expectedOutput = {1, 2, 3, 4, 5};
        int[] result = receiveWinningNumbers(input);
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
