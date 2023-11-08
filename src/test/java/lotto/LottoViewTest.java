package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoViewTest extends NsTest {

    @Test
    void 구입금액_유효성_Test() {
        assertSimpleTest(() -> {
            runException("8888");
            assertThat(output()).contains("[ERROR] 가격은 1000단위여야 합니다.");
        });
    }

    @Test
    void 보너스_번호_유효성_Test(){
        assertSimpleTest(() -> {
            runException("8000","1,2,3,4,5,6","j");
            assertThat(output()).contains("[ERROR] 보너스 번호가 잘못된 값을 가집니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
