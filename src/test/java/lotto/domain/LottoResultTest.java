package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    
    private LottoResult lottoResult;
    private Map<Ranking, Integer> winningResult;
    
    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        winningResult = lottoResult.getWinningResult();
    }
    
    @DisplayName("처음 생성되는 Ranking의 개수들은 모두 0이다.")
    @Test
    void intialCountsIsZero() {
        // when // then
        for (Ranking ranking : winningResult.keySet()) {
            assertThat(winningResult.get(ranking)).isEqualTo(0);
        }
    }
    
    @DisplayName("로또 번호와 당첨 번호 사이 일치하는 숫자가 6개라면, Ranking.FIRST(1등)의 개수가 증가한다.")
    @Test
    void addRankingFirstCount() {
        // when
        lottoResult.addRankingCount(Ranking.FIRST, 6);
        
        // then
        assertThat(winningResult.get(Ranking.FIRST)).isEqualTo(1);
    }
    
    @DisplayName("로또 번호와 보너스 번호가 일치한다면, Ranking.SECOND(2등)의 개수가 증가한다.")
    @Test
    void executeBonus() {
        // given
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
        // when
        lottoResult.addRankingCount(Ranking.THIRD, 5);
        
        // then
        assertThat(winningResult.get(Ranking.THIRD)).isEqualTo(1);
    }
    
    @DisplayName("로또 번호와 당첨 번호 사이 일치하는 숫자가 4개라면, Ranking.FOURTH(4등)의 개수가 증가한다.")
    @Test
    void addRankingFourthCount() {
        // when
        lottoResult.addRankingCount(Ranking.FOURTH, 4);
        
        // then
        assertThat(winningResult.get(Ranking.FOURTH)).isEqualTo(1);
    }
    
    @DisplayName("로또 번호와 당첨 번호 사이 일치하는 숫자가 3개라면, Ranking.FIFTH(5등)의 개수가 증가한다.")
    @Test
    void addRankingFifthCount() {
        // when
        lottoResult.addRankingCount(Ranking.FIFTH, 3);
        
        // then
        assertThat(winningResult.get(Ranking.FIFTH)).isEqualTo(1);
    }
    
    @DisplayName("각 등수에 할당된 개수와 등수 금액이 곱해진 총 당첨 금액을 계산한다.")
    @Test
    void calculateTotalPrizeMoney() {
        // given
        winningResult.put(Ranking.FOURTH, winningResult.get(Ranking.FOURTH) + 2);
        winningResult.put(Ranking.FIFTH, winningResult.get(Ranking.FIFTH) + 1);
        
        int expected = Ranking.FOURTH.getPrizeMoney() * 2 + Ranking.FIFTH.getPrizeMoney();
        
        // when
        long actual = lottoResult.calculateTotalPrizeMoney();
        
        // then
        assertThat(actual).isEqualTo(expected);
    }
    
    @DisplayName("총 당첨 금액과 총 구매 로또 개수를 통해 총 수익률을 구한다.")
    @Test
    void calculateProfitRate() {
        // given
        int totalPrizeMoney = 5000;
        int purchaseAmount = 8000;
        
        double expected = 62.5;
        
        // when
        double actual = lottoResult.calculateProfitRate(totalPrizeMoney, purchaseAmount);
        
        // then
        assertThat(actual).isEqualTo(expected);
    }
}
