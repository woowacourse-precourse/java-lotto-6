package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningRank Enum class 테스트")
public class WinningRankTest {

    @DisplayName("로또 번호 일치 개수가 5개일 떄 보너스 번호 일치에 따라 2,3 등이 갈린다.")
    @Test
    void 로또2등3등테스트(){
        int matchCount = 5;
        Assertions.assertThat(WinningRank.SECOND_WINNER).isEqualTo(WinningRank.findWinningRank(matchCount, true));
        Assertions.assertThat(WinningRank.THIRD_WINNER).isEqualTo(WinningRank.findWinningRank(matchCount, false));
    }

    @DisplayName("로또 번호 일치에 따라 적절한 상금 주어지는 지 확인")
    @Test
    void 상금확인(){
        //1등
        Assertions.assertThat(WinningRank.JACKPOT.getReward())
                .isEqualTo(WinningRank.findWinningRank(6, false).getReward());
        //2등
        Assertions.assertThat(WinningRank.SECOND_WINNER.getReward())
                .isEqualTo(WinningRank.findWinningRank(5, true).getReward());
        //3등
        Assertions.assertThat(WinningRank.THIRD_WINNER.getReward())
                .isEqualTo(WinningRank.findWinningRank(5, false).getReward());
        //4등
        Assertions.assertThat(WinningRank.FOURTH_WINNER.getReward())
                .isEqualTo(WinningRank.findWinningRank(4, false).getReward());
        //5등
        Assertions.assertThat(WinningRank.FIFTH_WINNER.getReward())
                .isEqualTo(WinningRank.findWinningRank(3, false).getReward());
        //그외
        Assertions.assertThat(WinningRank.NO_LUCK.getReward())
                .isEqualTo(WinningRank.findWinningRank(2, false).getReward());
        Assertions.assertThat(WinningRank.NO_LUCK.getReward())
                .isEqualTo(WinningRank.findWinningRank(1, false).getReward());
        Assertions.assertThat(WinningRank.NO_LUCK.getReward())
                .isEqualTo(WinningRank.findWinningRank(0, false).getReward());
    }

}
