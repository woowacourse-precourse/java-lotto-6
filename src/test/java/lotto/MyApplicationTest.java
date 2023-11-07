package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class MyApplicationTest extends NsTest {

    @Test
    void 예외_테스트_중복된_당첨번호() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        });
    }

    @Test
    void 예외_테스트_중복된_당첨번호_보너스번호() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains("[ERROR] 보너스 값은 입력된 6자리 값과 중복될 수 없습니다.");
        });
    }

    @Test
    void 예외_테스트_숫자가_아닌_당첨번호() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,k");
            assertThat(output()).contains("[ERROR] 반드시 숫자로만 입력해야 합니다.");
        });
    }

    @Test
    void 예외_테스트_숫자가_아닌_보너스번호() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "k");
            assertThat(output()).contains("[ERROR] 반드시 숫자로만 입력해야 합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
