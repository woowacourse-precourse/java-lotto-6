package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.MockNumberGenerator;
import lotto.domain.user.LottoCount;
import lotto.domain.user.UserLotto;
import lotto.domain.win.Bonus;
import lotto.domain.win.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    @DisplayName("당첨내역을 제대로 계산하는지 확인한다.")
    void checkCompareSystem() {
        LottoCount lottoCount = new LottoCount(1000);
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(new MockNumberGenerator());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.compare(userLotto, winLotto);

        assertThat(lottoMachine.getWinStatus().get(new LottoResult(4, 0))).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨내역을 제대로 계산하는지 확인한다._2")
    void checkCompareSystem_2() {
        LottoCount lottoCount = new LottoCount(1000);
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(new MockNumberGenerator());

        Lotto lotto = new Lotto(List.of(1, 2, 4, 6, 8, 10));
        Bonus bonus = new Bonus(3);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.compare(userLotto, winLotto);

        assertThat(lottoMachine.getWinStatus().get(new LottoResult(3, 0))).isEqualTo(0);
    }

    @Test
    @DisplayName("당첨내역를 제대로 계산하는지 확인한다._3")
    void checkCompareSystem_3() {
        LottoCount lottoCount = new LottoCount(1000);
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(new MockNumberGenerator());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 5, 7, 9));
        Bonus bonus = new Bonus(11);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.compare(userLotto, winLotto);

        assertThat(lottoMachine.getWinStatus().get(new LottoResult(5, 1))).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 제대로 계산하는지 확인한다.")
    void checkCalculateRate() {
        LottoCount lottoCount = new LottoCount(1000);
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(new MockNumberGenerator());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.compare(userLotto, winLotto);

        assertThat(lottoMachine.calculateRate(userLotto)).isEqualTo(5000);
    }
}
