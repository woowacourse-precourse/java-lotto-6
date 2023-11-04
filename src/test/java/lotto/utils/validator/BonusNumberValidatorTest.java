package lotto.utils.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest extends NsTest {


    @Test
    void 숫자_포맷_테스트(){
            assertSimpleTest(() -> {
                runException("A");
                assertThat(output()).contains("숫자만");
            });
        }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}