package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    @DisplayName("2개 이하 일치한 경우")
    void no_match() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);

        Lotto[] lottos = new Lotto[2];
        lottos[0] = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        lottos[1] = new Lotto(List.of(1, 8, 9, 10, 11, 12));

        Referee referee = new Referee(winningNumber);
        assertThat(referee.countLottosWithMatches(lottos, LottoPrize.THREE_MATCH)).isEqualTo(0);
        assertThat(referee.countLottosWithMatches(lottos, LottoPrize.FOUR_MATCH)).isEqualTo(0);
        assertThat(referee.countLottosWithMatches(lottos, LottoPrize.FIVE_MATCH_WITH_BONUS)).isEqualTo(0);
        assertThat(referee.countLottosWithMatches(lottos, LottoPrize.FIVE_MATCH)).isEqualTo(0);
        assertThat(referee.countLottosWithMatches(lottos, LottoPrize.SIX_MATCH)).isEqualTo(0);
    }

    @Test
    @DisplayName("5개 일치한 경우 보너스 번호 여부 체크")
    void five_match_with_bonus() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);

        Lotto[] lottos = new Lotto[2];
        lottos[0] = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottos[1] = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        Referee referee = new Referee(winningNumber);
        assertThat(referee.countLottosWithMatches(lottos, LottoPrize.FIVE_MATCH_WITH_BONUS)).isEqualTo(1);
        assertThat(referee.countLottosWithMatches(lottos, LottoPrize.FIVE_MATCH)).isEqualTo(1);
    }
}