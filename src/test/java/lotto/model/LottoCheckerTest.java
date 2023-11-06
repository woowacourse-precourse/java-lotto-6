package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    @Test
    void 당첨_번호와_티켓을_비교해_결과를_저장한다() {
        LottoChecker lottoChecker = new LottoChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        final int matchCount = lottoChecker.getMatchCount(ticket);
        final boolean hasBonusNumber = lottoChecker.hasBonusNumber(ticket);

        assertThat(matchCount).isEqualTo(5);
        assertThat(hasBonusNumber).isTrue();
    }

}