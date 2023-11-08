package lotto.userInterface;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PurchaseTest extends NsTest {
    private static final String MINIMUM_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";
    private static final String INPUT_TYPE_ERROR_MESSAGE = "[ERROR] 올바른 형식이 아닙니다. 1000원 단위로 다시 입력해주세요.";

    @Test
    void testMinimumAmountError() {
        assertSimpleTest(() -> {
            runException("900");
            assertThat(output()).contains(MINIMUM_ERROR_MESSAGE);
        });
    }


    @Test
    void testInvalidInputType_1() {
        assertSimpleTest(() -> {
            runException("1000a");
            assertThat(output()).contains(INPUT_TYPE_ERROR_MESSAGE);
        });
    }


    @Test
    void testInvalidInputType_2() {
        assertSimpleTest(() -> {
            runException("&1000");
            assertThat(output()).contains(INPUT_TYPE_ERROR_MESSAGE);
        });
    }


    @Test
    void testNotDivisibleByThousand() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(INPUT_TYPE_ERROR_MESSAGE);
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
