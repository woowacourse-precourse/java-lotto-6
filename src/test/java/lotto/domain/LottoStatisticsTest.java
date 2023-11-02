package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoStatisticsTest {
    @Test
    @DisplayName("구매한 로또 N장에 대한 당첨 기록을 조회한다")
    void getWinningResult() {
        // given
        final WinningLottoHolder winningLottoHolder = createLottoWinningMachine();
        final User userLottoCaseA = createUsersCaseA();
        final User userLottoCaseB = createUsersCaseB();
        final User userLottoCaseC = createUsersCaseC();

        // when
        final LottoStatistics caseA = LottoStatistics.checkLottoResult(winningLottoHolder, userLottoCaseA);
        final LottoStatistics caseB = LottoStatistics.checkLottoResult(winningLottoHolder, userLottoCaseB);
        final LottoStatistics caseC = LottoStatistics.checkLottoResult(winningLottoHolder, userLottoCaseC);

        // then
        final Map<WinningRank, Integer> winningResultA = caseA.getWinningResult();
        assertAll(
                () -> assertThat(winningResultA.get(WinningRank.FIRST)).isEqualTo(1),
                () -> assertThat(winningResultA.get(WinningRank.SECOND)).isEqualTo(1),
                () -> assertThat(winningResultA.get(WinningRank.THIRD)).isEqualTo(1),
                () -> assertThat(winningResultA.get(WinningRank.FOURTH)).isEqualTo(2),
                () -> assertThat(winningResultA.get(WinningRank.FIFTH)).isEqualTo(2),
                () -> assertThat(winningResultA.get(WinningRank.NONE)).isEqualTo(5)
        );

        final Map<WinningRank, Integer> winningResultB = caseB.getWinningResult();
        assertAll(
                () -> assertThat(winningResultB.get(WinningRank.FIRST)).isEqualTo(0),
                () -> assertThat(winningResultB.get(WinningRank.SECOND)).isEqualTo(0),
                () -> assertThat(winningResultB.get(WinningRank.THIRD)).isEqualTo(0),
                () -> assertThat(winningResultB.get(WinningRank.FOURTH)).isEqualTo(0),
                () -> assertThat(winningResultB.get(WinningRank.FIFTH)).isEqualTo(3),
                () -> assertThat(winningResultB.get(WinningRank.NONE)).isEqualTo(14)
        );

        final Map<WinningRank, Integer> winningResultC = caseC.getWinningResult();
        assertAll(
                () -> assertThat(winningResultC.get(WinningRank.FIRST)).isEqualTo(0),
                () -> assertThat(winningResultC.get(WinningRank.SECOND)).isEqualTo(0),
                () -> assertThat(winningResultC.get(WinningRank.THIRD)).isEqualTo(0),
                () -> assertThat(winningResultC.get(WinningRank.FOURTH)).isEqualTo(0),
                () -> assertThat(winningResultC.get(WinningRank.FIFTH)).isEqualTo(1),
                () -> assertThat(winningResultC.get(WinningRank.NONE)).isEqualTo(7)
        );
    }

    private WinningLottoHolder createLottoWinningMachine() {
        return WinningLottoHolder.drawWinningLotto(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                7
        );
    }

    private User createUsersCaseA() {
        return User.provideLottos(
                List.of(
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(1, 2, 3, 11, 12, 13)), // 5등 (당첨 3개)
                        Lotto.create(Arrays.asList(1, 2, 3, 7, 12, 13)), // 5등 (당첨 3개 + 보너스 1개)
                        Lotto.create(Arrays.asList(1, 2, 3, 4, 12, 13)), // 4등 (당첨 4개)
                        Lotto.create(Arrays.asList(1, 2, 3, 4, 7, 13)), // 4등 (당첨 4개 + 보너스 1개)
                        Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 13)), // 3등 (당첨 5개)
                        Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등 (당첨 5개 + 보너스 1개)
                        Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6)) // 1등 (당첨 6개)
                )
        );
    }

    private User createUsersCaseB() {
        return User.provideLottos(
                List.of(
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(8, 9, 10, 11, 12, 13)), // None
                        Lotto.create(Arrays.asList(1, 2, 3, 11, 12, 13)), // 5등 (당첨 3개)
                        Lotto.create(Arrays.asList(1, 2, 3, 11, 12, 13)), // 5등 (당첨 3개)
                        Lotto.create(Arrays.asList(1, 2, 3, 7, 12, 13)) // 5등 (당첨 3개 + 보너스 1개)
                )
        );
    }

    private User createUsersCaseC() {
        return User.provideLottos(
                List.of(
                        Lotto.create(Arrays.asList(8, 21, 23, 41, 42, 43)), // None
                        Lotto.create(Arrays.asList(3, 5, 11, 16, 32, 38)), // None
                        Lotto.create(Arrays.asList(7, 11, 16, 35, 36, 44)), // None
                        Lotto.create(Arrays.asList(1, 8, 11, 31, 41, 42)), // None
                        Lotto.create(Arrays.asList(13, 14, 16, 38, 42, 45)), // None
                        Lotto.create(Arrays.asList(7, 11, 30, 40, 42, 43)), // None
                        Lotto.create(Arrays.asList(2, 13, 22, 32, 38, 45)), // None
                        Lotto.create(Arrays.asList(1, 3, 5, 14, 22, 45)) // 5등 (당첨 3개)
                )
        );
    }
}
