package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.logic.LottoLogic;
import lotto.view.ConsoleView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogicTest extends NsTest {

    @Override
    protected void runMain() {
        new LottoLogic(new InputController(new ConsoleView()), new LottoController()).run();
    }

    @Test
    @DisplayName("지불금액 1000원 단위 에러처리")
    void provideIllegalInteger() {
        runException("5001");
        assertThat(output()).contains("[ERROR] 지불 금액은 1000원 단위의 양수여야 합니다.");
    }

    @Test
    @DisplayName("지불금액 음수 에러처리")
    void provideNegativeInteger() {
        runException("-5000");
        assertThat(output()).contains("[ERROR] 지불 금액은 1000원 단위의 양수여야 합니다.");
    }

    @Test
    @DisplayName("지불금액 문자 에러처리")
    void provideCharacter() {
        runException("5jfe");
        assertThat(output()).contains("[ERROR] 입력은 숫자만으로 이루어져야 합니다.");
    }
}
