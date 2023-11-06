package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusInputTest extends NsTest {
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
