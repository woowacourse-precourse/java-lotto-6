package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.LottoConfig;
import lotto.enums.WinningRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구매 금액에 맞는 로또 개수를 발행한다.")
    @Test
    void createLottoByPayAmount() {
        // given
        int payAmount = 18000;

        // when
        List<Lotto> lottos = lottoService.publishLottos(payAmount);

        // then
        assertThat(lottos.size()).isEqualTo(payAmount / LottoConfig.LOTTO_AMOUNT.getValue());
    }

    @DisplayName("당첨 결과를 통계한다.")
    @Test
    void getWinningStatistics() {
        // given
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.publishLottos(4000);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 9, 8, 10),
                List.of(9, 8, 10, 4, 5, 6)

        );

        List<Integer> jackpotNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        HashMap<WinningRank, Integer> winningStatistics = lottoService.getWinningStatistics(jackpotNumbers,
                bonusNumber);

        // then
        assertThat(winningStatistics.get(WinningRank.FIRST)).isEqualTo(1);
        assertThat(winningStatistics.get(WinningRank.SECOND)).isEqualTo(1);
        assertThat(winningStatistics.get(WinningRank.FIFTH)).isEqualTo(2);
    }

    @DisplayName("당첨 금액의 총액을 계산한다.")
    @Test
    void getTotalReturnAmount() {
        // given
        int firstCount = 1;
        int secondCount = 2;
        int thirdCount = 3;
        int fourthCount = 4;
        int fifthCount = 5;
        HashMap<WinningRank, Integer> winningStatistics = new HashMap<>();
        winningStatistics.put(WinningRank.FIRST, firstCount);
        winningStatistics.put(WinningRank.SECOND, secondCount);
        winningStatistics.put(WinningRank.THIRD, thirdCount);
        winningStatistics.put(WinningRank.FOURTH, fourthCount);
        winningStatistics.put(WinningRank.FIFTH, fifthCount);

        // when
        long returnAmount = lottoService.calculateReturnAmount(winningStatistics);

        // then
        assertThat(returnAmount).isEqualTo(WinningRank.FIRST.getReturnAmount() * firstCount
                + (long) WinningRank.SECOND.getReturnAmount() * secondCount
                + (long) WinningRank.THIRD.getReturnAmount() * thirdCount
                + (long) WinningRank.FOURTH.getReturnAmount() * fourthCount
                + (long) WinningRank.FIFTH.getReturnAmount() * fifthCount);
    }

    @DisplayName("당첨 금액과 구매 금액을 바탕으로 수익률을 계산한다.")
    @Test
    void getRateOfReturn() {
        // given
        int payAmount = 8000;
        long returnAmount = 5000;

        // when
        double rateOfReturn = lottoService.getRateOfReturn(payAmount, returnAmount);

        // then
        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}
