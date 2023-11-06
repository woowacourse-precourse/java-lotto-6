package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitTest {
    @Test
    void check_5000() {
        LottoResult lottoResult = LottoResult.of(3, false);
        lottoResult.setResult();
        Profit profit = Profit.from(8000);
        assertThat(profit.getProfit()).isEqualTo(62.5);
    }

    @Test
    void check_31500000() {
        LottoResult lottoResult_1500000 = LottoResult.of(5, false);
        lottoResult_1500000.setResult();
        LottoResult lottoResult_30000000 = LottoResult.of(6, true);
        lottoResult_30000000.setResult();
        Profit profit = Profit.from(100000);
        assertThat(profit.getProfit()).isEqualTo(31500.0);
    }
}
