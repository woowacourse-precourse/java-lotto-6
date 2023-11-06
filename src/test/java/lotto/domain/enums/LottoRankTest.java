package lotto.domain.enums;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @DisplayName("로또 5등 당첨 - 3개 번호 일치")
    @Test
    void fifthRank() {
        // given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(13, 14, 15, 3, 2, 1));
        WinningNumber winningNumber = new WinningNumber(winningLotto, 9);

        // when
        LottoRank lottoRank = LottoRank.getResult(userLotto, winningNumber);

        // then
        assertThat(lottoRank.getPrize()).isEqualTo(5000);
    }

    @DisplayName("로또 3등 당첨 - 5개 번호 일치")
    @Test
    void thirdRank() {
        // given
        Lotto userLotto = new Lotto(List.of(3, 5, 10, 15, 20, 33));
        Lotto winningLotto = new Lotto(List.of(3, 5, 15, 10, 33, 45));
        WinningNumber winningNumber = new WinningNumber(winningLotto, 21);

        // when
        LottoRank lottoRank = LottoRank.getResult(userLotto, winningNumber);

        // then
        assertThat(lottoRank.getPrize()).isEqualTo(1500000);
    }

    @DisplayName("로또 2등 당첨 - 5개 번호 일치 / 보너스 번호 일치")
    @Test
    void secondRank() {
        // given
        Lotto userLotto = new Lotto(List.of(3, 5, 10, 15, 20, 33));
        Lotto winningLotto = new Lotto(List.of(3, 5, 15, 10, 33, 45));
        WinningNumber winningNumber = new WinningNumber(winningLotto, 20);

        // when
        LottoRank lottoRank = LottoRank.getResult(userLotto, winningNumber);

        // then
        assertThat(lottoRank.getPrize()).isEqualTo(30000000);
    }
}
