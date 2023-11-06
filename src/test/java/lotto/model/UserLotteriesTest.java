package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLotteriesTest {

    @DisplayName("당첨 로또 번호가 주어지면 사용자의 당첨 등수 별 당첨 횟수를 반환한다.")
    @Test
    void findWinningCount() {
        //given
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)));
        Lotto lotto3 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto4 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 15, 16)));
        Lotto lotto5 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 14, 15, 16)));
        Lotto lotto6 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 14, 15, 7)));
        UserLotteries userLotteries =
                new UserLotteries(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));

        Lotto winningLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, 7);

        //when
        Map<LottoPrize, Long> winningCount = userLotteries.findWinningCount(winningLottoWithBonus);

        //then
        assertThat(winningCount.get(LottoPrize.FIRST_PRIZE)).isEqualTo(2);
        assertThat(winningCount.get(LottoPrize.SECOND_PRIZE)).isEqualTo(1);
        assertThat(winningCount.get(LottoPrize.THIRD_PRIZE)).isEqualTo(0);
        assertThat(winningCount.get(LottoPrize.FOURTH_PRIZE)).isEqualTo(1);
        assertThat(winningCount.get(LottoPrize.FIRST_PRIZE)).isEqualTo(2);
    }

    @DisplayName("당첨 로또 번호가 주어지면 당첨된 값이 없다면 당첨 등수별 횟수는 모두 0이다.")
    @Test
    void findWinningCountZero() {
        //given
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(11, 21, 31, 41, 15, 16)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(12, 22, 33, 41, 15, 9)));
        Lotto lotto3 = new Lotto(new ArrayList<>(List.of(13, 21, 31, 44, 15, 8)));
        Lotto lotto4 = new Lotto(new ArrayList<>(List.of(14, 24, 33, 43, 45, 10)));
        UserLotteries userLotteries =
                new UserLotteries(List.of(lotto1, lotto2, lotto3, lotto4));

        Lotto winningLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, 7);

        //when
        Map<LottoPrize, Long> winningCount = userLotteries.findWinningCount(winningLottoWithBonus);

        //then
        assertThat(winningCount.get(LottoPrize.FIRST_PRIZE)).isEqualTo(0);
        assertThat(winningCount.get(LottoPrize.SECOND_PRIZE)).isEqualTo(0);
        assertThat(winningCount.get(LottoPrize.THIRD_PRIZE)).isEqualTo(0);
        assertThat(winningCount.get(LottoPrize.FOURTH_PRIZE)).isEqualTo(0);
        assertThat(winningCount.get(LottoPrize.FIRST_PRIZE)).isEqualTo(0);
    }

}