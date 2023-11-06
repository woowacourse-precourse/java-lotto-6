package lotto.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

    @Test
    void 자동_로또를_생성한다() {
        // when
        Lotto lotto = lottoMachine.createLottoByAuto();

        // then
        assertNotNull(lotto);
    }

    @Test
    void 수동_로또를_생성한다() {
        // when
        Lotto lotto = lottoMachine.createLottoByManual(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertNotNull(lotto);
    }

    @Test
    void 보너스_번호를_생성한다() {
        // given
        int bonus = 1;

        // when
        LottoNumber bonusNumber = lottoMachine.createBonusNumber(bonus);

        // then
        assertNotNull(bonusNumber);
    }
}