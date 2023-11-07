package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoControlTest extends NsTest {
    @Test
    void 로또가격_예외_테스트() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains("[ERROR] 구입한 값은 0 초과의 정수여야 합니다.");
        });
        assertSimpleTest(() -> {
            runException("500");
            assertThat(output()).contains("[ERROR] 구입한 값은 1000의 배수인 정수여야 합니다.");
        });
    }


    @Test
    void 로또번호_중복_테스트() {
        List<Lotto> randomNumbers = LottoModel.generateLottos(10000);
        for (Lotto numbers : randomNumbers) {
            assertThat(new HashSet<>(numbers.getNumbers())).hasSize(6);
        }
    }

    @Test
    void 당첨번호_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5a,6");
            assertThat(output()).contains("[ERROR] 당첨 번호는 정수여야 합니다. (공백 불허)");
        });
    }

    @Test
    void 보너스번호_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "5a");
            assertThat(output()).contains("[ERROR] 보너스 번호는 정수여야 합니다.");
        });
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "50");
            assertThat(output()).contains("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "4");
            assertThat(output()).contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
