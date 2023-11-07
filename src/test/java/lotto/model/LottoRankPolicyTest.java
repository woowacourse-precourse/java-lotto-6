package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.enums.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankPolicyTest {

    private LottoRankPolicy lottoRankPolicy;

    @DisplayName("숫자가 6개 맞았을 때 1등 결과를 출력한다")
    @Test
    void firstPrizeRankTest(){
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        lottoRankPolicy = new LottoRankPolicy(winningNumbers, bonusNumber);

        // then
        Assertions.assertThat(lottoRankPolicy.calculateRank(lotto1)).isEqualTo(LottoRank.FIRST_PRIZE.name());
    }

    @DisplayName("숫자가 5개 맞고 보너스 넘버가 같을때 2등 결과를 출력한다")
    @Test
    void secontPrizeRankTest(){
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        lottoRankPolicy = new LottoRankPolicy(winningNumbers, bonusNumber);

        // then
        Assertions.assertThat(lottoRankPolicy.calculateRank(lotto1)).isEqualTo(LottoRank.SECOND_PRIZE.name());
    }

    @DisplayName("숫자가 5개 맞았을 때 3등 결과를 출력한다")
    @Test
    void thirdPrizeRankTest(){
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        lottoRankPolicy = new LottoRankPolicy(winningNumbers, bonusNumber);

        // then
        Assertions.assertThat(lottoRankPolicy.calculateRank(lotto1)).isEqualTo(LottoRank.THIRD_PRIZE.name());
    }

    @DisplayName("숫자가 4개 맞았을 때 4등 결과를 출력한다")
    @Test
    void fourthPrizeRankTest(){
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        lottoRankPolicy = new LottoRankPolicy(winningNumbers, bonusNumber);

        // then
        Assertions.assertThat(lottoRankPolicy.calculateRank(lotto1)).isEqualTo(LottoRank.FOURTH_PRIZE.name());
    }

    @DisplayName("숫자가 3개 맞았을 때 5등 결과를 출력한다")
    @Test
    void fifthPrizeRankTest(){
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        lottoRankPolicy = new LottoRankPolicy(winningNumbers, bonusNumber);

        // then
        Assertions.assertThat(lottoRankPolicy.calculateRank(lotto1)).isEqualTo(LottoRank.FIFTH_PRIZE.name());
    }

    @DisplayName("숫자가 2개 이하 맞았을 때 낙첨 결과를 출력한다")
    @Test
    void noPrizeRankTest(){
        /**
         * List.of(11, 12, 13, 14, 15, 16)
         * List.of(1, 12, 13, 14, 15, 16)
         * List.of(1, 2, 13, 14, 15, 16)
         */
        // given
        Lotto lotto1 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        lottoRankPolicy = new LottoRankPolicy(winningNumbers, bonusNumber);

        // then
        Assertions.assertThat(lottoRankPolicy.calculateRank(lotto1)).isEqualTo(LottoRank.NO_PRIZE.name());
    }
}