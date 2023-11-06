package lotto.verifier;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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

    @Nested
    class ExceptionTest {

        private final Verifier bonusNumberVerifier = new BonusNumberVerifier();
        @Test
        void 숫자가아닌_보너스번호가_주어진경우() {
            assertThatThrownBy(() -> bonusNumberVerifier.check("13k"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMERIC);
        }
        @Test
        void Long_타입으로변환될수없는_보너스번호가_주어진경우(){
            BigInteger LongExceedingMax = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.TEN);
            assertThatThrownBy(() -> bonusNumberVerifier.check(LongExceedingMax.toString()))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
        }
        @Test
        void 보너스번호가_1부터45사이의_숫자가_아닌경우() {
            assertThatThrownBy(() -> bonusNumberVerifier.check("48"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}