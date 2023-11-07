package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("로또 결과는 정렬된 List로 반환한다.")
    @Test
    void getSortedResultList() {
        // given
        LottoResult lottoResult = LottoResult.of(Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 2,
                Rank.THIRD, 3,
                Rank.FOURTH, 4,
                Rank.FIFTH, 5,
                Rank.MISS, 6
        ));

        // when
        List<Map.Entry<Rank, Integer>> sortedResultList = lottoResult.getSortedResultList();

        // then
        assertThat(sortedResultList).containsExactly(
                Map.entry(Rank.MISS, 6),
                Map.entry(Rank.FIFTH, 5),
                Map.entry(Rank.FOURTH, 4),
                Map.entry(Rank.THIRD, 3),
                Map.entry(Rank.SECOND, 2),
                Map.entry(Rank.FIRST, 1)
        );
    }

    @DisplayName("로또 결과의 총 상금을 반환한다.")
    @Test
    void getTotalPrizeMoney() {
        // given
        LottoResult lottoResult = LottoResult.of(Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 5,
                Rank.MISS, 6
        ));

        // when
        long totalPrizeMoney = lottoResult.getTotalPrizeMoney();

        // then
        assertThat(totalPrizeMoney).isEqualTo(25000);
    }
}
