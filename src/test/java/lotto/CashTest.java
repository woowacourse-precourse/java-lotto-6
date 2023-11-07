package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import lotto.model.Cash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashTest {

    @Test
    @DisplayName("Cash의 출력 메소드는 기존에 저장되어 있던 Cash 값이어야 한다.")
    void cash() {
        assertSimpleTest(() -> assertThat(new Cash("3000").cash()).isEqualTo(3000L));
    }
}