package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.UserLotteries;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class UsersPrizeLottoCounterTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void createWinningLotto() {
        Lotto winningLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        this.winningLotto = new WinningLotto(winningLotto, 7);
    }

    @DisplayName("당첨 로또 번호가 주어지면 사용자의 당첨 등수 별 당첨 횟수를 반환한다.")
    @ParameterizedTest
    @EnumSource(
            value = LottoPrize.class,
            names = {"FIRST_PRIZE", "SECOND_PRIZE"}
    )
    void findWinningCount(LottoPrize lottoPrize) {
        //given
        Lotto firstPrize = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto secondPrize = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)));
        UserLotteries userLotteries = new UserLotteries(List.of(firstPrize, secondPrize));
        //when
        Map<LottoPrize, Long> winningCount = UsersPrizeLottoCounter.countPrizeLotto(winningLotto, userLotteries);
        //then
        assertThat(winningCount.get(lottoPrize)).isEqualTo(1);
    }

    @DisplayName("당첨 로또 번호가 주어지면 당첨된 값이 없다면 당첨 등수별 횟수는 모두 0이다.")
    @ParameterizedTest
    @EnumSource(
            value = LottoPrize.class,
            names = {"FIRST_PRIZE", "SECOND_PRIZE", "THIRD_PRIZE", "FOURTH_PRIZE", "FIFTH_PRIZE"}
    )
    void findWinningCountZero(LottoPrize lottoPrize) {
        //given
        UserLotteries userLotteries = new UserLotteries(List.of());
        //when
        Map<LottoPrize, Long> winningCount = UsersPrizeLottoCounter.countPrizeLotto(winningLotto, userLotteries);
        //then
        assertThat(winningCount.get(lottoPrize)).isEqualTo(0);
    }

}