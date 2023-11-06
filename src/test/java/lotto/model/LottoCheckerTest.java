package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    @Test
    void 당첨_번호와_보너스_번호를_티켓을_비교해_등수를_반환한다() {
        final LottoChecker lottoChecker = new LottoChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        final Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        final LottoRank lottoRank = lottoChecker.checkTicket(ticket);

        assertThat(lottoRank.getOutputString(1))
            .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }

}