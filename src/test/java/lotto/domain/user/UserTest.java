package lotto.domain.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lottomachine.LottoMachine;
import lotto.domain.shop.Shop;
import lotto.mock.TestLottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @DisplayName("수익률 계산 테스트")
    @Test
    void getProfitRateTest() {
        // given
        User user = new User();
        LottoMachine lottoMachine = new TestLottoMachine();
        user.buyLotto(8000, new Shop(lottoMachine));
        WinningLotto winningLotto = new WinningLotto(List.of(11, 12, 13, 14, 15, 16), 17);
        user.checkLottoResult(winningLotto);
        // when
        double profitRate = user.getProfitRate();
        // then
        assertEquals(62.5, profitRate);
    }

    @DisplayName("로또 구매 테스트")
    @Test
    void buyLottoTest() {
        // given
        User user = new User();
        LottoMachine lottoMachine = new TestLottoMachine();
        // when
        user.buyLotto(8000, new Shop(lottoMachine));
        // then
        Assertions.assertThat(user.getLottos()).hasSize(8);
    }

    @DisplayName("로또 결과 확인 테스트")
    @Test
    void checkLottoResultTest() {
        // given
        User user = new User();
        LottoMachine lottoMachine = new TestLottoMachine();
        user.buyLotto(8000, new Shop(lottoMachine));
        WinningLotto winningLotto = new WinningLotto(List.of(11, 12, 13, 14, 15, 16), 17);
        // when
        user.checkLottoResult(winningLotto);
        // then
        Assertions.assertThat(user.getRankCount().get(Rank.FIFTH)).isEqualTo(1);
        Assertions.assertThat(user.getRankCount().get(Rank.MISS)).isEqualTo(7);
    }
}