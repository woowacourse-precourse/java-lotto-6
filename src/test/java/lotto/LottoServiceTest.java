package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.LottoConfig;
import lotto.enums.WinningRank;
import lotto.service.LottoService;
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
}
