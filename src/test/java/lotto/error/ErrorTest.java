package lotto.error;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.utils.Casher;
import lotto.utils.enums.ErrorMessage;
import org.junit.jupiter.api.Test;

public class ErrorTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 예외_테스트_가격_1000원_미만() {
        assertSimpleTest(() -> {
            runException("900");
            assertThat(output())
                    .contains(ERROR_MESSAGE)
                    .contains(Casher.NOT_ENOUGH_PRICE);
        });
    }

    @Test
    void 예외_테스트_가격_1000원_단위X() {
        assertSimpleTest(() -> {
            runException("1300");
            assertThat(output())
                    .contains(ERROR_MESSAGE)
                    .contains(Casher.NOT_LOTTO_UNIT);
        });
    }

    @Test
    void 예외_테스트_당첨번호_미입력() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5");
            assertThat(output())
                    .contains(ERROR_MESSAGE)
                    .contains(ErrorMessage.LACK_NUMBER_COUNT.getMessage());
        });
    }

    @Test
    void 예외_테스트_당첨번호_중복() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,5");
            assertThat(output())
                    .contains(ERROR_MESSAGE)
                    .contains(ErrorMessage.NOT_DUPLICATED.getMessage());
        });
    }

    @Test
    void 예외_테스트_보너스번호_미입력() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6"," ");
            assertThat(output())
                    .contains(ERROR_MESSAGE)
                    .contains(ErrorMessage.NOT_BLANK_NUMBER.getMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
