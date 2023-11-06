package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyInputTest extends NsTest {
    @DisplayName("유저가 정수가 아닌 금액(문자열)을 입력할 경우")
    @Test
    void userInputStringMoney(){
        assertSimpleTest(() -> {
            runException("abc");
            assertThat(output()).contains(Message.ERROR_MONEY);
        });
    }

    @DisplayName("유저가 정수가 아닌 금액(실수)을 입력할 경우")
    @Test
    void userInputDoubleMoney(){
        assertSimpleTest(() -> {
            runException("1000.0");
            assertThat(output()).contains(Message.ERROR_MONEY);
        });
    }

    @DisplayName("유저가 로또금액으로 떨어지지 않는 정수를 입력할 경우")
    @Test
    void userInputNotDivisableMoney(){
        assertSimpleTest(() -> {
            runException("3600");
            assertThat(output()).contains(Message.ERROR_MONEY);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
