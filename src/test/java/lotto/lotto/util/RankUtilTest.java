package lotto.lotto.util;

import lotto.domain.Rank;
import lotto.util.RankUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankUtilTest {
    @DisplayName("비어있는 배열의 당첨 금액을 계산할 수 없다.")
    @Test
    void getProfitsWithBlankRank() {
        assertThatThrownBy(() -> RankUtil.getProfits(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨금액의 합을 올바르게 계산해야 한다.")
    @Test
    void getProfits() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.SECOND);
        long sum = Rank.FIRST.getWinningMoney() + Rank.SECOND.getWinningMoney();

        Assertions.assertEquals(RankUtil.getProfits(ranks), sum);
    }

    @DisplayName("비어있는 배열의 결과를 출력할 수 없다.")
    @Test
    void printResultWithBlankRank() {
        assertThatThrownBy(() -> RankUtil.printResult(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 통계를 계산해야 한다.")
    @Test
    void printResult() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.SECOND);

        Assertions.assertDoesNotThrow(() -> RankUtil.printResult(ranks));
    }
}
