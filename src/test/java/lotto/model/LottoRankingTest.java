package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankingTest {

    @Test
    @DisplayName("getRanking을 통해 적중 갯수와 보너스볼 적중 여부로 LottoRanking을 만들 수 있다.")
    void getRankingTest() {
        assertThat(LottoRanking.getRanking(3, false))
            .isInstanceOf(LottoRanking.class);
    }

    @Test
    @DisplayName("적중 갯수가 5개 일때, 보너스볼 적중 여부를 통해 2등과 3등을 구분할 수 있다.")
    void getSecondAndThirdRankingTest() {
        LottoRanking rankingBonusBallHit = LottoRanking.getRanking(5, true);
        LottoRanking rankingBonusBallNotHit = LottoRanking.getRanking(5, false);

        assertAll(
            () -> assertThat(rankingBonusBallHit).isEqualTo(LottoRanking.SECOND),
            () -> assertThat(rankingBonusBallNotHit).isEqualTo(LottoRanking.THIRD)
        );
    }
}
