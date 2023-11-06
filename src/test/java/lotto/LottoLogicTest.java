package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.logic.LottoLogic;
import lotto.view.ConsoleView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoLogicTest extends NsTest {

    @Override
    protected void runMain() {
        new LottoLogic(new ConsoleView()).run();
    }

    @Test
    @DisplayName("지불금액 1000원 단위 에러처리")
    void provideIllegalInteger() {
        runException("5001");
        assertThat(output()).contains("[ERROR] 지불 금액은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("지불금액 음수 에러처리")
    void provideNegativeInteger() {
        runException("-5000");
        assertThat(output()).contains("[ERROR] 지불 금액은 0 보다 커야 합니다.");
    }

    @Test
    @DisplayName("지불금액 문자 에러처리")
    void provideCharacter() {
        runException("5jfe");
        assertThat(output()).contains("[ERROR] 지불 금액은 정수여야 합니다.");
    }
}
