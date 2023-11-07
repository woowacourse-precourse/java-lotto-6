package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningInputTest extends NsTest {
    @DisplayName("당첨 번호에 정수가 아닌 수가 포함된 경우")
    @Test
    void userInputStringWinningNumber(){
        assertSimpleTest(() -> {
            runException("1000", "a,b,c,d,e,f");
            assertThat(output()).contains(Message.ERROR_WINNING_RANGE);
        });
    }

    @DisplayName("당첨 번호에 범위를 벗어나는 수가 포함된 경우")
    @Test
    void userInputInvalidRangeWinningNumber(){
        assertSimpleTest(() -> {
            runException("1000", "-1,2,3,4,5,46");
            assertThat(output()).contains(Message.ERROR_WINNING_RANGE);
        });
    }

    @DisplayName("당첨 번호를 적게 입력할 경우")
    @Test
    void userInputLessWinningNumber(){
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(Message.ERROR_WINNING_COUNT);
        });
    }

    @DisplayName("당첨 번호를 더 많이 입력할 경우")
    @Test
    void userInputMoreWinningNumber(){
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(Message.ERROR_WINNING_COUNT);
        });
    }

    @DisplayName("당첨 번호를 중복으로 입력할 경우")
    @Test
    void userInputDuplicatedWinningNumber(){
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(Message.ERROR_WINNING_DUPLICATE);
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
