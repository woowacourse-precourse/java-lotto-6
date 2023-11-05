package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Nested
    class 구입금액_입력_테스트 extends NsTest {
        private static final String ONLY_NUMERIC_INPUT_FOR_MONEY = "[ERROR] 구입금액은 숫자만 입력 가능합니다.";

        @Test
        void 구입금액이_숫자가_아닌_경우_예외() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("input"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ONLY_NUMERIC_INPUT_FOR_MONEY);
            });
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            inputView.inputMoney();
        }
    }
}
