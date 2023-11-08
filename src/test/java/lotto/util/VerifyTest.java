package lotto.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.util.Verify.verifyAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VerifyTest extends NsTest {
    public static final Integer CAN_BUY_VALUE = 14000;
    public static final String CAN_BUY = "14000";
    public static final Integer CAN_BUY_VALUE2 = 1000;
    public static final String CAN_BUY2 = "1000";
    public static final String CAN_NOT_BUY = "100";
    public static final String CAN_NOT_BUY2 = "999";

    @Test
    void 값이1000원이상일경우() {
        assertSimpleTest(() -> {
            assertThat(verifyAmount(CAN_BUY)).isEqualTo(CAN_BUY_VALUE);
        });
    }

    @Test
    void 값이1000원이상일경우2() {
        assertSimpleTest(() -> {
            assertThat(verifyAmount(CAN_BUY2)).isEqualTo(CAN_BUY_VALUE2);
        });
    }
    @Test
    void 값이1000원미만일경우() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> verifyAmount(CAN_NOT_BUY))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값이1000원미만일경우2() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> verifyAmount(CAN_NOT_BUY2))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Override
    public void runMain() {
        new Verify();
    }
}
