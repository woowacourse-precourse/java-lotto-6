package lotto.game;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import lotto.AmountToBuyLotto;
import lotto.Constants.NumberOfLottoCorrect;
import lotto.LottoNumber;
import lotto.WinningNumber;
import lotto.WinningStatistic;
import lotto.YieldRate;
import lotto.random.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    RandomNumberGenerator mockRandomNumberGenerator = mock(RandomNumberGenerator.class);

    @Test
    void 로또_판매() {
        // given
        LottoGame lottoGame = new LottoGame(mockRandomNumberGenerator);
        AmountToBuyLotto amountToBuyLotto = AmountToBuyLotto.newInstance("10000");
        // when
        when(mockRandomNumberGenerator.generateRandomNumbers()).thenReturn(Arrays.asList(1,2,3,4,5,6));
        lottoGame.saleLotto(amountToBuyLotto);
        // then
    }

    @Test
    void 발급된_로또_메세지_기능() {
        // given
        LottoGame lottoGame = new LottoGame(mockRandomNumberGenerator);
        AmountToBuyLotto amountToBuyLotto = AmountToBuyLotto.newInstance("3000");
        String result =
            "3개를 구매했습니다.\n"
                + "[1, 2, 3, 4, 5, 6]\n"
                + "[1, 2, 3, 4, 5, 6]\n"
                + "[1, 2, 3, 4, 5, 6]";
        // when
        when(mockRandomNumberGenerator.generateRandomNumbers()).thenReturn(Arrays.asList(1,2,3,4,5,6));
        lottoGame.saleLotto(amountToBuyLotto);
        String issuedLottosMessage = lottoGame.getIssuedLottosMessage();
        // then
        assertThat(issuedLottosMessage).contains(result);
    }

    @Test
    void 당첨통계_만드는_기능() {
        // given
        LottoGame lottoGame = new LottoGame(mockRandomNumberGenerator);
        AmountToBuyLotto amountToBuyLotto = AmountToBuyLotto.newInstance("1000");
        WinningNumber winningNumber = WinningNumber.newInstance("4,5,6,7,8,9");
        LottoNumber bonusNumber = LottoNumber.newInstance("1");
        WinningStatistic result = WinningStatistic.newInstance();
        result.increaseCount(NumberOfLottoCorrect.FOUR_MATCHES);
        // when
        when(mockRandomNumberGenerator.generateRandomNumbers()).thenReturn(Arrays.asList(1,2,3,4,5,6));
        lottoGame.saleLotto(amountToBuyLotto);
        WinningStatistic winningStatistic = lottoGame.createWinningStatistic(winningNumber,
            bonusNumber);
        // then
        assertThat(winningStatistic.getStatisticMessage()).contains(result.getStatisticMessage());
    }

    @Test
    void 수익률_만드는_기능() {
        // given
        LottoGame lottoGame = new LottoGame(mockRandomNumberGenerator);
        AmountToBuyLotto amountToBuyLotto = AmountToBuyLotto.newInstance("1000");
        WinningNumber winningNumber = WinningNumber.newInstance("4,5,6,7,8,9");
        LottoNumber bonusNumber = LottoNumber.newInstance("1");
        WinningStatistic winningStatistic = WinningStatistic.newInstance();
        winningStatistic.increaseCount(NumberOfLottoCorrect.FOUR_MATCHES);
        // when
        YieldRate yieldRate = lottoGame.calculateYieldRate(amountToBuyLotto, winningStatistic);
        // then
        assertThat(yieldRate.getRateMessage()).contains("총 수익률은 5000.0%입니다");
    }
}