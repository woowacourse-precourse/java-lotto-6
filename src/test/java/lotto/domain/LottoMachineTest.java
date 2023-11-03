package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @Test
    @DisplayName("입력받은 금액에 맞는 갯수의 lotto 티켓을 발행한다.")
    void buyLotto() {
        // given
        Integer amount = 14000;
        Money money = new Money(amount);

        // when
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottoBundle = lottoMachine.buyLotto(money);

        // then
        Integer expectLottoCount = 14;
        assertThat(lottoBundle.size()).isEqualTo(expectLottoCount);
    }

}