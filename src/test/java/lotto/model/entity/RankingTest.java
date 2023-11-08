package lotto.model.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("일치하는 번호가 6개면 1등을 반환한다")
    @Test
    void findByMatchCountAndBonus_First() {
        assertThat(Ranking.findByMatchCountAndBonus(6, false)).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("일치하는 번호가 5개이고 보너스 볼이 맞으면 2등을 반환한다")
    @Test
    void findByMatchCountAndBonus_Second() {
        assertThat(Ranking.findByMatchCountAndBonus(5, true)).isEqualTo(Ranking.SECOND);
    }

    @DisplayName("일치하는 번호가 5개이고 보너스 볼이 틀리면 3등을 반환한다")
    @Test
    void findByMatchCountAndBonus_Third() {
        assertThat(Ranking.findByMatchCountAndBonus(5, false)).isEqualTo(Ranking.THIRD);
    }

    @DisplayName("로또 번호와 당첨 번호가 모두 일치하면 1등을 결정한다")
    @Test
    void determineRanking_First() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ranking result = Ranking.determineRanking(lotto, winningNumbers, 7);
        assertThat(result).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("로또 번호가 5개와 보너스 번호가 일치하면 2등을 결정한다")
    @Test
    void determineRanking_Second() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ranking result = Ranking.determineRanking(lotto, winningNumbers, 7);
        assertThat(result).isEqualTo(Ranking.SECOND);
    }

    @DisplayName("로또 번호가 5개 일치하면 3등을 결정한다")
    @Test
    void determineRanking_Third() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ranking result = Ranking.determineRanking(lotto, winningNumbers, 7);
        assertThat(result).isEqualTo(Ranking.THIRD);
    }

    @DisplayName("로또 번호가 4개 일치하면 4등을 결정한다")
    @Test
    void determineRanking_Fourth() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ranking result = Ranking.determineRanking(lotto, winningNumbers, 7);
        assertThat(result).isEqualTo(Ranking.FOURTH);
    }

    @DisplayName("로또 번호가 3개 일치하면 5등을 결정한다")
    @Test
    void determineRanking_Fifth() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ranking result = Ranking.determineRanking(lotto, winningNumbers, 7);
        assertThat(result).isEqualTo(Ranking.FIFTH);
    }

    @DisplayName("로또 번호가 2개 이하로만 일치하면 당첨되지 않음")
    @Test
    void determineRanking_NoPrize() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 10, 11, 12, 13));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ranking result = Ranking.determineRanking(lotto, winningNumbers, 7);
        assertThat(result).isEqualTo(Ranking.NO_PRIZE);
    }

}
