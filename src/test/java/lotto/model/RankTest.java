package lotto.model;

import static lotto.model.Rank.SECOND;
import static lotto.model.Rank.THIRD;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void secondRankTest() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        Assertions.assertThat(Rank.sort(lottoTicket, winningLottoTicket).get())
                .isEqualTo(SECOND);
    }

    @Test
    void thirdRankTest() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                8
        );
        Assertions.assertThat(Rank.sort(lottoTicket, winningLottoTicket).get())
                .isEqualTo(THIRD);
    }
}
