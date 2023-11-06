package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.Profit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitTest {

    @ParameterizedTest
    @CsvSource({
            "8000, 5000, 62.5",
            "10000, 2000000000, 20000000.0",
            "5000, 50000, 1000.0",
            "7000, 50000, 714.2857142857143",
    })
    void create(long money, long prize, double expected) {
        Profit profit = Profit.of(money, prize);
        assertThat(profit.getValue()).isEqualTo(expected);
    }
}
