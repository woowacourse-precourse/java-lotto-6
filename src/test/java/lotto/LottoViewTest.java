package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoViewTest extends NsTest {

    @Test
    void inputValidateTest() {
        assertSimpleTest(() -> {
            runException("8888");
            assertThat(output()).contains("[ERROR] 가격은 1000단위여야 합니다.");
        });
    }

    @Test
    void inputBonusNumberValidateTest(){
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
