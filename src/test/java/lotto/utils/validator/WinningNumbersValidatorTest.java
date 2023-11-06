package lotto.utils.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
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
    void 당첨번호_숫자_테스트() {
        assertSimpleTest(() -> {
            runException("3000","1,2,3,4,A,5");
            assertThat(output()).contains("숫자만");
        });
    }

    @Test
    void 보너스_번호_숫자_포맷_테스트() {
        assertSimpleTest(() -> {
            runException("20000","1,2,3,4,5,6","A");
            assertThat(output()).contains("숫자만");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}