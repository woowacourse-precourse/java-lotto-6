package lotto.domain;

import static lotto.domain.MatchingCase.NEW_GAME;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ProfitTest {
    @Test
    void check_5000() {
        NEW_GAME.initMatchingCase();
        LottoResult lottoResult = LottoResult.of(3, false);
        lottoResult.recordMatchingCaseResults();
        Profit profit = Profit.from(NEW_GAME.getResult(), 8000);
        assertThat(profit.getProfit()).isEqualTo(62.5);
    }

    @Test
    void check_31500000() {
        NEW_GAME.initMatchingCase();
        LottoResult lottoResult_1500000 = LottoResult.of(5, false);
        lottoResult_1500000.recordMatchingCaseResults();
        LottoResult lottoResult_30000000 = LottoResult.of(5, true);
        lottoResult_30000000.recordMatchingCaseResults();
        Profit profit = Profit.from(NEW_GAME.getResult(), 100000);
        assertThat(profit.getProfit()).isEqualTo(31500.0);
    }
}
