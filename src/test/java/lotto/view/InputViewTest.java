package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.config.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {
    private final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("구매금액 테스트")
    void inputMoney() {
        assertSimpleTest(()->{
            runException("-100","1000");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "1개를 구매했습니다."
                    );
        });
    }

    @Test
    @DisplayName("당첨 번호 테스트")
    void winningNumber() {
        assertSimpleTest(()->{
            runException("5000","1,2,3,4,5,5","1,2,3,4,5","1,,3,4,5,6","1,2,3,4,5,-10","abc,2,3,4,5,6");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    ErrorMessage.DUPLICATED_ERROR.getMessage(),
                    ErrorMessage.BLANK_ERROR.getMessage(),
                    ErrorMessage.LENGTH_ERROR.getMessage(),
                    ErrorMessage.RANGE_ERROR.getMessage(),
                    ErrorMessage.NUM_ERROR.getMessage()
            );
        });
    }

    @Test
    @DisplayName("보너스 번호 테스트")
    void bonusNumber() {
        assertSimpleTest(()->{
            runException("5000","1,2,3,4,5,6","abc","1","70");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    ErrorMessage.NUM_ERROR.getMessage(),
                    ErrorMessage.BONUS_DUPLICATED_ERROR.getMessage(),
                    ErrorMessage.RANGE_ERROR.getMessage()
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}