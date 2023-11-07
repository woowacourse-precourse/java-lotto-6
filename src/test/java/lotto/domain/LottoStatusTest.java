package lotto.domain;

import static lotto.domain.model.PrizeConstant.FIRST_REWARD;
import static lotto.domain.model.PrizeConstant.SECOND_REWARD;
import static lotto.domain.model.PrizeConstant.THIRD_REWARD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatusTest {

    @Test
    @DisplayName("1등부터 5등까지 중 하나의 값을 선택하여 당첨 수의 상태를 증가해주는 기능을 한다."
            + "단 범위 외의 값이 넘어 올때는 무시하도록 구현하였다.")
    void increaseRankingCountTest() {
        LottoStatus lottoStatus = new LottoStatus();
        lottoStatus.increaseRankingCount(1);
        lottoStatus.increaseRankingCount(2);
        lottoStatus.increaseRankingCount(3);
        lottoStatus.increaseRankingCount(9);
        lottoStatus.increaseRankingCount(0);
    }

    @Test
    @DisplayName("매치된 홧수를 바탕으로 해당 등수 값을 1씩 증가 시켜준다.")
    void calculateTotalRevenue() {
        //given
        LottoStatus lottoStatus = new LottoStatus();
        lottoStatus.increaseRankingCount(1);
        lottoStatus.increaseRankingCount(2);
        lottoStatus.increaseRankingCount(3);
        /*
        1등 한번 +  2등 한번  + 3등 한번
         */
        Integer expect = FIRST_REWARD + SECOND_REWARD + THIRD_REWARD;
        //when
        Integer actual = lottoStatus.calculateTotalRevenue();
        //then
        assertThat(actual).isEqualTo(expect);
    }
}