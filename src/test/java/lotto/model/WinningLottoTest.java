package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest extends NsTest {

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void createWinningLottoByBonusNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());

            runException("1000", "45,2,3,4,5,6", "45");
            assertThat(output()).contains(ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());
        });
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되지 않으면 당첨 로또가 생성된다.")
    @Test
    void createWinningLotto() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "7");
            assertThat(output()).doesNotContain(ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
