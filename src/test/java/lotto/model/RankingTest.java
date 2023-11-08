package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankingTest {
    @DisplayName("잘못된 랭킹 값 입력")
    @Test
    void createRankingWithWrongParameters() {
        assertThatThrownBy(() -> Ranking.getRanking(1, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랭킹과 당첨 횟수에 따른 상금")
    @Test
    void checkPriceByRankingAndCount() {
        // given
        PriceMoney priceMoney = new PriceMoney(30_000);
        Ranking fifth = Ranking.FIFTH;

        // when, then
        assertThat(fifth.calculateCurrentPrice(6)).isEqualTo(priceMoney);
    }
}
