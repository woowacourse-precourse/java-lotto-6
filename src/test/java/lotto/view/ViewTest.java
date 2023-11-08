package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ViewTest extends NsTest {

    @DisplayName("구입금액에 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    @Test
    void inputNonNumericCost() {
        assertSimpleTest(() -> {
            runException("abcdef");
            assertThat(output()).contains("[ERROR] 20억 이하의 숫자를 입력해주세요.");
        });
    }

    @Test
    void inputAndValidateWinningLotto() {
    }

    @Test
    void inputAndValidateBonus() {
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}