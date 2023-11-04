package lotto.utils.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.utils.validator.WinningNumbersValidator;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest extends NsTest {

    @Test
    void 콤마_위치_테스트(){
        assertSimpleTest(() -> {
            runException("3000",",1,2,3,4,5,6");
            assertThat(output()).contains("콤마");
        });

        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,5,6,");
            assertThat(output()).contains("콤마");
        });
    }

    @Test
    void 숫자_테스트() {
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,A,5");
            assertThat(output()).contains("숫자만");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}