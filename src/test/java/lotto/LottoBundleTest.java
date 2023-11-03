package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import lotto.domain.LottoBundle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoBundleTest {

    private static LottoBundle bundle;

    @BeforeEach
    void beforeEach() {
        bundle = new LottoBundle();
    }

    @Test
    void makeLotto() {
        // given
        String case1 = "10000";
        String case2 = "333";
        String case3 = "";
        String case4 = "ajsdklf";

        // when
        Throwable result1 = catchThrowable(() -> {
            bundle.makeLotto(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            bundle.makeLotto(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            bundle.makeLotto(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            bundle.makeLotto(case4);
        });

        // then
        assertThat(bundle.getBundle().size()).as("case1 result").isEqualTo(10);
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("case4").isInstanceOf(IllegalArgumentException.class);
    }
}