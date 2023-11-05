package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.ResultRepository;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
    Lotto FourthRankLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 15, 16)));
    Lotto NoneRankLotto = new Lotto(new ArrayList<>(List.of(11, 12, 13, 14, 15, 16)));
    ResultRepository FourthRankRepository = new ResultRepository(winningLotto, FourthRankLotto);
    ResultRepository NoneRankRepository = new ResultRepository(winningLotto, NoneRankLotto);

    @DisplayName("당첨률 계산")
    @Test
    void WinningPercentage() {
        WinningStatistics winningStatistics = setOneFourthRank();
        assertThat(winningStatistics.getWinningRate()).isEqualTo(1666.7);

        winningStatistics = setTwoFourthRank();
        assertThat(winningStatistics.getWinningRate()).isEqualTo(3333.3);
    }

    @DisplayName("당첨 통계 출력 테스트")
    @Test
    void WinningDetail() {
        final WinningStatistics winningStatistics = setTwoFourthRank();

        assertThat(winningStatistics.getWinningDetail(Rank.First)).isEqualTo("6개 일치 (2,000,000,000원) - 0개");
        assertThat(winningStatistics.getWinningDetail(Rank.Fourth)).isEqualTo("4개 일치 (50,000원) - 2개");
    }

    private WinningStatistics setOneFourthRank() {
        return new WinningStatistics(
                List.of(FourthRankRepository, NoneRankRepository, NoneRankRepository));
    }

    private WinningStatistics setTwoFourthRank() {
        return new WinningStatistics(
                List.of(FourthRankRepository, FourthRankRepository, NoneRankRepository));
    }
}
