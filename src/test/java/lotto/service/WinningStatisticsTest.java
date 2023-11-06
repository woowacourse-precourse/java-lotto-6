package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.ResultRepository;
import lotto.domain.WinningLotto;
import lotto.domain.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningStatisticsTest {
    private static WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
    private static Lotto FourthRankLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 15, 16)));
    private static Lotto NoneRankLotto = new Lotto(new ArrayList<>(List.of(11, 12, 13, 14, 15, 16)));

    @ParameterizedTest
    @MethodSource("provideWinningLottoAndResult")
    @DisplayName("당첨률을 계산한다.")
    void calculateWinningPercentage(WinningStatistics winningStatistics, double result) {
        assertThat(winningStatistics.getWinningRate()).isEqualTo(result);
    }

    private static Stream<Arguments> provideWinningLottoAndResult() {
        return Stream.of(
                Arguments.of(setOneFourthRank(), 1666.7),
                Arguments.of(setTwoFourthRank(), 3333.3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideRankAndOutput")
    @DisplayName("당첨 통계 출력를 출력한다.")
    void winningDetail(Rank rank, String result) {
        final WinningStatistics winningStatistics = setTwoFourthRank();
        assertThat(winningStatistics.getWinningDetail(rank)).isEqualTo(result);
    }

    private static Stream<Arguments> provideRankAndOutput() {
        return Stream.of(
                Arguments.of(Rank.First, "6개 일치 (2,000,000,000원) - 0개"),
                Arguments.of(Rank.Fourth, "4개 일치 (50,000원) - 2개")
        );
    }

    private static ResultRepository getFourthRankRepository() {
        return new ResultRepository(winningLotto, FourthRankLotto);
    }

    private static ResultRepository getNoneRankRepository() {
        return new ResultRepository(winningLotto, NoneRankLotto);
    }

    private static WinningStatistics setOneFourthRank() {

        return new WinningStatistics(
                List.of(getFourthRankRepository(), getNoneRankRepository(), getNoneRankRepository()));
    }

    private static WinningStatistics setTwoFourthRank() {
        return new WinningStatistics(
                List.of(getFourthRankRepository(), getFourthRankRepository(), getNoneRankRepository()));
    }
}
