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
    public static final String CAN_NOT_BUY = "100";

    @Test
    void 값이1000원이상일경우() {
        assertSimpleTest(() -> {
            assertThat(verifyAmount(CAN_BUY)).isEqualTo(CAN_BUY_VALUE);
        });
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> verifyAmount(CAN_NOT_BUY))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        new Verify();
    }
}
