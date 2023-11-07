package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest extends NsTest {
    @Test
    void not_six() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains("여섯 개를 입력");
        });
    }

    @Test
    void non_number() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,q,w,e");
            assertThat(output()).contains("숫자를 입력");
        });
    }

    @Test
    void not_in_range() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains("1 ~ 45 범위 내의 숫자를 입력");
        });
    }

    @Test
    void duplicate_numbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains("서로 다른 숫자를 입력");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
