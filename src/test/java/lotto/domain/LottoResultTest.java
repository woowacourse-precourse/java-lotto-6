package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    
    @DisplayName("처음 생성되는 Ranking의 개수들은 모두 0이다.")
    @Test
    void intialCountsIsZero() {
        // given
        LottoResult lottoResult = new LottoResult();
        Map<Ranking, Integer> winningResult = lottoResult.getWinningResult();
        
        // when // then
        for (Ranking ranking : winningResult.keySet()) {
            assertThat(winningResult.get(ranking)).isEqualTo(0);
        }
    }
    
    @DisplayName("로또 번호와 당첨 번호 사이 일치하는 숫자가 6개라면, Ranking.FIRST(1등)의 개수가 증가한다.")
    @Test
    void addRankingFirstCount() {
        // given
        LottoResult lottoResult = new LottoResult();
        Map<Ranking, Integer> winningResult = lottoResult.getWinningResult();
        
        // when
        lottoResult.addRankingCount(Ranking.FIRST, 6);
        
        // then
        assertThat(winningResult.get(Ranking.FIRST)).isEqualTo(1);
    }
    
    @DisplayName("로또 번호와 보너스 번호가 일치한다면, Ranking.SECOND(2등)의 개수가 증가한다.")
    @Test
    void executeBonus() {
        // given
        LottoResult lottoResult = new LottoResult();
        Map<Ranking, Integer> winningResult = lottoResult.getWinningResult();
        
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        
        // when
        lottoResult.executeBonus(lotto, bonusNumber);
        
        // then
        assertThat(winningResult.get(Ranking.SECOND)).isEqualTo(1);
    }
    
    @DisplayName("로또 번호와 당첨 번호 사이 일치하는 숫자가 5개라면, Ranking.THIRD(3등)의 개수가 증가한다.")
    @Test
    void addRankingTHIRDCount() {
        // given
        LottoResult lottoResult = new LottoResult();
        Map<Ranking, Integer> winningResult = lottoResult.getWinningResult();
        
        // when
        lottoResult.addRankingCount(Ranking.THIRD, 5);
        
        // then
        assertThat(winningResult.get(Ranking.THIRD)).isEqualTo(1);
    }
    
    @DisplayName("로또 번호와 당첨 번호 사이 일치하는 숫자가 4개라면, Ranking.FOURTH(4등)의 개수가 증가한다.")
    @Test
    void addRankingFourthCount() {
        // given
        LottoResult lottoResult = new LottoResult();
        Map<Ranking, Integer> winningResult = lottoResult.getWinningResult();
        
        // when
        lottoResult.addRankingCount(Ranking.FOURTH, 4);
        
        // then
        assertThat(winningResult.get(Ranking.FOURTH)).isEqualTo(1);
    }
    
    @DisplayName("로또 번호와 당첨 번호 사이 일치하는 숫자가 3개라면, Ranking.FIFTH(5등)의 개수가 증가한다.")
    @Test
    void addRankingFifthCount() {
        // given
        LottoResult lottoResult = new LottoResult();
        Map<Ranking, Integer> winningResult = lottoResult.getWinningResult();
        
        // when
        lottoResult.addRankingCount(Ranking.FIFTH, 3);
        
        // then
        assertThat(winningResult.get(Ranking.FIFTH)).isEqualTo(1);
    }
}
