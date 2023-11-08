package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningInformationTest {
    private List<Rank> ranks = List.of(
            Rank.LOSER,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIRST,
            Rank.SECOND
    );
    private WinningInformation winningInformation = WinningInformation.of(ranks);

    @DisplayName("Rank list를 Rank 당 개수 Map으로 변환한다.")
    @Test
    void testInstanceCreation() {
        //given
        //when
        Map<Rank, Integer> result = winningInformation.getWinningCounts();

        //then
        assertThat(result)
                .containsEntry(Rank.LOSER, 1)
                .containsEntry(Rank.FIFTH, 2)
                .containsEntry(Rank.FIRST, 1)
                .containsEntry(Rank.SECOND, 1)
                .containsEntry(Rank.THIRD, 0);
    }

    @DisplayName("총 수입과 비용의 비율을 계산한다.")
    @Test
    void testGetProfitability() {
        //given
        double expectedProfitability = (double) (Rank.FIFTH.getPrize() * 2 +
                Rank.FIRST.getPrize() +
                Rank.SECOND.getPrize()) / 5000 * 100;

        //when
        double actualProfitability = winningInformation.getProfitability();

        //then
        assertThat(actualProfitability).isEqualTo(expectedProfitability);
    }
}