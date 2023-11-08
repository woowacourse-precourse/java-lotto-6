package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("로또가 2등에 해당할 때 올바른 상금을 반환한다.")
    void returnsSecondPrizeForSecondRank() {
        // given
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 45)), 6);

        // when
        LottoRank rank = LottoRank.calculate(new Lotto(List.of(1, 2, 3, 4, 5, 6)), winningNumber);

        // then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
        assertThat(rank.getPrize()).isEqualTo(LottoRank.SECOND.getPrize());
    }

    @Test
    @DisplayName("로또가 3등에 해당할 때 올바른 상금을 반환한다.")
    void returnsThirdPrizeForThirdRank() {
        // given
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 45)), 40);

        // when
        LottoRank rank = LottoRank.calculate(new Lotto(List.of(1, 2, 3, 4, 5, 6)), winningNumber);

        // then
        assertThat(rank).isEqualTo(LottoRank.THIRD);
        assertThat(rank.getPrize()).isEqualTo(LottoRank.THIRD.getPrize());
    }

    @Test
    @DisplayName("유효한 로또 순위의 개수를 올바르게 반환한다.")
    void returnsValidRankCount() {
        // given
        List<LottoRank> validRanks = LottoRank.findValidRanks();

        // when
        // then
        assertThat(validRanks).hasSize(5);
    }

    @Test
    @DisplayName("로또가 5등에 해당할 때의 수익을 계산한다.")
    void calculatesEarningsForFifthRank() {
        // given
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);

        // when
        LottoRank rank = LottoRank.calculate(new Lotto(List.of(1, 2, 3, 43, 44, 45)), winningNumber);
        List<LottoRank> lottoRanks = Collections.singletonList(rank);
        long earnings = LottoRank.calculate(lottoRanks);

        // then
        assertThat(earnings).isEqualTo(LottoRank.FIFTH.getPrize());
    }

    @Test
    @DisplayName("특정 등수의 로또 개수를 계산한다.")
    void calculatesCorrectRankCount() {
        // given
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);

        // when
        LottoRank rank = LottoRank.calculate(new Lotto(List.of(1, 2, 3, 43, 44, 45)), winningNumber);
        List<LottoRank> lottoRanks = Collections.singletonList(rank);
        long count = rank.calculateCount(lottoRanks);

        // then
        assertThat(count).isEqualTo(1); // 5등 로또 1개
    }

}
