package lotto;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    void 중복_번호_입력() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 공백_입력() {
        assertSimpleTest(() -> {
            runException("1000", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 문자_입력() {
        assertSimpleTest(() -> {
            runException("1000", "lotto,number,good,apple,bunny,little");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 잘못된_숫자_입력() {
        assertSimpleTest(() -> {
            runException("1000", "0,-1,46,47,-2,-3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 중복_보너스_번호_입력() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 잘못된_숫자_보너스_번호_입력() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

