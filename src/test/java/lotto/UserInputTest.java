package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest extends NsTest {
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

    @DisplayName("보너스 번호를 정수로 입력하지 않는 경우")
    @Test
    void userInputStringBonusNumber(){
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(Message.ERROR_BONUS_RANGE);
        });
    }

    @DisplayName("보너스 번호가 1 미만의 수로 입력하는 경우")
    @Test
    void userInputInvalidLessRangeBonusNumber(){
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "-1");
            assertThat(output()).contains(Message.ERROR_BONUS_RANGE);
        });
    }

    @DisplayName("보너스 번호가 45 초과의 수로 입력하는 경우")
    @Test
    void userInputInvalidMoreRangeBonusNumber(){
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "56");
            assertThat(output()).contains(Message.ERROR_BONUS_RANGE);
        });
    }

    @DisplayName("보너스 번호를 여러개 입력하는 경우")
    @Test
    void userInputMultipleBonusNumber(){
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "7,8");
            assertThat(output()).contains(Message.ERROR_BONUS_RANGE);
        });
    }

    @DisplayName("보너스 번호를 당첨번호와 중복되게 입력하는 경우")
    @Test
    void userInputDuplicatedBonusNumber(){
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(Message.ERROR_BONUS_DUPLICATE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
