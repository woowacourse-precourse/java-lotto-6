package lotto.model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    private static final int BONUS_NUMBER = 7;
    private static final int WINNING_SECOND = 30000000;
    private static final int WINNING_THIRD = 1500000;

    private static List<Integer> winningNumber;
    private static List<Lotto> lottos;

    @BeforeEach
    public void init() {
        winningNumber = List.of(1, 2, 3, 4, 5, 6);

        lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));   //2등
        lottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));   //2등
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));   //3등
    }

    @DisplayName("당첨 번호와 로또 번호의 일치하는 숫자 개수 계산 테스트 (2등, 3등 테스트)")
    @Test
    public void checkCorrectLottoNumber() {
        //given
        WinningResult.checkWinning(BONUS_NUMBER, winningNumber, lottos);

        //when
        int result1 = WinningResult.SIX_WINNING_WITH_BONUS.getWinningCount();
        int expect1 = 2;

        int result2 = WinningResult.FIVE_WINNING.getWinningCount();
        int expect2 = 1;

        //then
        Assertions.assertThat(result1).isEqualTo(expect1);
        Assertions.assertThat(result2).isEqualTo(expect2);
    }

    @DisplayName("총 수익률 계산 테스트 (2등_2개 + 3등_1개 수익률)")
    @Test
    public void checkTotalEarningRate() {
        //given
        int purchaseMoney = 10000;
        WinningResult.checkWinning(BONUS_NUMBER, winningNumber, lottos);

        //when
        double result = WinningResult.calculateEarning(purchaseMoney);
        double expect = Math.round(((double) (WINNING_SECOND * 2 + WINNING_THIRD) / purchaseMoney * 1000.0)) / 10.0;

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}