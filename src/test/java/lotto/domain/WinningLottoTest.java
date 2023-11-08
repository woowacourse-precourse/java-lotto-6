package lotto.domain;

import lotto.domain.validation.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("6개 번호가 모두 일치할 경우, 1등을 반환해야 한다.")
    void match_firstRank() {
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningTicket, 7);
        LottoTicket userTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoRank rank = winningLotto.match(userTicket);

        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치할 경우, 2등을 반환해야 한다.")
    void match_secondRank() {
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningTicket, 7);
        LottoTicket userTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));

        LottoRank rank = winningLotto.match(userTicket);

        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("5개 번호가 일치할 경우, 3등을 반환해야 한다.")
    void match_thirdRank() {
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningTicket, 7);
        LottoTicket userTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 8));

        LottoRank rank = winningLotto.match(userTicket);

        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4개 번호가 일치할 경우, 4등을 반환해야 한다.")
    void match_fourthRank() {
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningTicket, 7);
        LottoTicket userTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9));

        LottoRank rank = winningLotto.match(userTicket);

        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("3개 번호가 일치할 경우, 5등을 반환해야 한다.")
    void match_fifthRank() {
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningTicket, 7);
        LottoTicket userTicket = new LottoTicket(Arrays.asList(1, 2, 3, 8, 9, 10));

        LottoRank rank = winningLotto.match(userTicket);

        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("일치하는 번호가 없을 경우, '없음(NONE)을 반환해야 한다.'")
    void match_noWin() {
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningTicket, 7);
        LottoTicket userTicket = new LottoTicket(Arrays.asList(8, 9, 10, 11, 12, 13));

        LottoRank rank = winningLotto.match(userTicket);

        assertThat(rank).isEqualTo(LottoRank.NONE);
    }
}
