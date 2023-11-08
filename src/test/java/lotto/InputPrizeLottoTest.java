package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputPrizeLottoTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    //로또번호 입력 기능
    @Test
    void 예외_테스트_빈칸_입력() {
        assertSimpleTest(() -> {
            runException("1000", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_입력_형태_오류() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_입력_번호_개수() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_입력_번호_문자_여부() {
        assertSimpleTest(() -> {
            runException("1000", "a,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_입력_번호_범위_작은수() {
        assertSimpleTest(() -> {
            runException("1000", "-1,1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_입력_번호_범위_큰수() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_입력_번호_중복() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    //보너스번호 입력 기능
    @Test
    void 예외_테스트_보너스_번호_빈칸_입력() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_숫자_외_입력() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5", "O");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_범위_작은수() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5", "-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_보너스_번호_범위_큰수() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
