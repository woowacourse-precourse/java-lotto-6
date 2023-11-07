package lotto;

import lotto.domain.Lottos;
import lotto.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {
    @DisplayName("1000으로 나누어 떨어지지 않는 금액 입력 시 예외가 발생한다.")
    @Test
    void 천원_단위가_아닌_금액_예외테스트() {
        assertThatThrownBy(() -> new Lottos(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액에 맞는 횟수만큼 로또를 발행한다.")
    @Test
    void 로또_발행_테스트() {
        long money = 15000;
        int count = (int) (money / Constants.PRICE_UNIT.getValues());
        Lottos lottos = new Lottos(money);
        assertThat(lottos.getLottos().size()).isEqualTo(count);
    }
}