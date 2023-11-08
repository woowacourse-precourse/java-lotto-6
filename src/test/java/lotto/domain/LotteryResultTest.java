package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LotteryRankConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryResultTest {
    @DisplayName("당첨번호와 보너스 번호가 주어지고, 사용자의 로또 번호가 주어지면 몇등인지 판별한다.")
    @Test
    void judgeUserLottoRank() {
        // given
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
        BonusNumber bonusNumber = BonusNumber.of(7, winningLottoNumbers.getWinningLottoNumbers());
        LotteryResult lotteryResult = LotteryResult.of(winningLottoNumbers, bonusNumber);

        Lotto firstRankLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdRankLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 8));
        Lotto fourthRankLotto = Lotto.from(List.of(1, 2, 3, 4, 8, 9));
        Lotto fifthRankLotto = Lotto.from(List.of(1, 2, 3, 10, 11, 12));

        // when, then
        assertThat(lotteryResult.judgeRank(firstRankLotto)).isEqualTo(LotteryRankConstant.FIRST_RANK);
        assertThat(lotteryResult.judgeRank(secondRankLotto)).isEqualTo(LotteryRankConstant.SECOND_RANK);
        assertThat(lotteryResult.judgeRank(thirdRankLotto)).isEqualTo(LotteryRankConstant.THIRD_RANK);
        assertThat(lotteryResult.judgeRank(fourthRankLotto)).isEqualTo(LotteryRankConstant.FOURTH_RANK);
        assertThat(lotteryResult.judgeRank(fifthRankLotto)).isEqualTo(LotteryRankConstant.FIFTH_RANK);
    }
}