package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.LotteryRankConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoRanksTest {
    @DisplayName("가지고 있는 유저의 로또 당첨 복권 등수 및 개수 정보를 기반으로 유저의 로또 당첨 금액을 계산해준다.")
    @Test
    void calculateWinningAmountOfUserLottos() {
        // given
        Map<LotteryRankConstant, Integer> lotteryRanks = new HashMap<>();
        lotteryRanks.put(LotteryRankConstant.FIRST_RANK, 2);
        lotteryRanks.put(LotteryRankConstant.SECOND_RANK, 2);
        lotteryRanks.put(LotteryRankConstant.THIRD_RANK, 1);
        lotteryRanks.put(LotteryRankConstant.FOURTH_RANK, 3);
        lotteryRanks.put(LotteryRankConstant.FIFTH_RANK, 1);

        // when
        UserLottoRanks userLottoRanks = UserLottoRanks.from(lotteryRanks);

        // then
        assertThat(userLottoRanks.calculateWinningAmount()).isEqualTo(4061655000L);
    }
}