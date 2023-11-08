package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingTest {
    @DisplayName("특정 순위를 출력하는지 테스트")
    @Test
    void createRanking(){
        String Output = Ranking.getMatchRankMessage(2);
        Assertions.assertEquals(Output,"5개 일치, 보너스 볼 일치 (30,000,000원) - ");
    }
    @DisplayName("잘못된 순위가 입력될 경우 예외가 발생한다.")
    @Test
    void createRankingByErrorValue(){
        assertThatThrownBy(() -> Ranking.getMatchRankMessage(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
