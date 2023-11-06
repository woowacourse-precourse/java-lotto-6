package lotto.verifier;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;


class BonusNumberVerifierTest extends NsTest {

    @Nested
    class ValidInputTest {
        @Test
        void 정상입력이_주어진경우() {
            Assertions.assertSimpleTest(() -> {
                assertThatCode(() -> run("14000", "1,2,3,4,5,6","7"))
                        .doesNotThrowAnyException();
            });
        }
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}