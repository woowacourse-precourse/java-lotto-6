package lotto.input;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputRetryHelperTest extends NsTest {
    static final int RE_TRY_COUNT = 2;
    static final int RE_TRY_BASE = 2;

    @Test
    void retryTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    runMain();
                },
                RE_TRY_BASE - 1, RE_TRY_BASE - 1, RE_TRY_BASE + 1
        );
    }

    @Override
    protected void runMain() {
        InputRetryHelper<Integer> retryable = new InputRetryHelper<Integer>();
        retryable.retry(() -> {
            int random = Randoms.pickNumberInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (random < RE_TRY_BASE) {
                System.out.println("재시도");
                throw new IllegalArgumentException("10 미만은 재시도");
            }
            return random;
        });
        assertThat(retryable.getRetryCount())
                .isEqualTo(RE_TRY_COUNT);
    }
}