package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BudgetTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 100, 1_010})
    void 유효하지_않은_금액_예외(int input) {
        Budget budget = new Budget(input);
        assertThatIllegalArgumentException().isThrownBy(() -> budget.makeTicket());
    }

    @ParameterizedTest
    @CsvSource({
            "3000, 3",
            "10000, 10",
            "100000, 100"
    })
    void 로또_티켓_생성(int input, int expectedTickets) {
        Budget budget = new Budget(input);
        assertEquals(expectedTickets, budget.makeTicket());
    }
}