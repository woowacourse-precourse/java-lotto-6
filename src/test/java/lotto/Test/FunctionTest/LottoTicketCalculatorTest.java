package lotto.Test.FunctionTest;
import lotto.model.lottoGenerator.LottoTicketCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketCalculatorTest {

    @Test
    @DisplayName("구매 금액이 1000원일 때, 티켓 1개를 반환해야 한다")
    public void calculateNumberOfTickets_WhenAmountIsOneThousand_ShouldReturnOneTicket() {
        LottoTicketCalculator calculator = new LottoTicketCalculator();
        int tickets = calculator.calculateNumberOfTickets(1000);
        assertEquals(1, tickets, "1000원에 대한 티켓 수가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("구매 금액이 1000원 미만일 때, 티켓 0개를 반환해야 한다")
    public void calculateNumberOfTickets_WhenAmountIsLessThanOneThousand_ShouldReturnZeroTickets() {
        LottoTicketCalculator calculator = new LottoTicketCalculator();
        int tickets = calculator.calculateNumberOfTickets(999);
        assertEquals(0, tickets, "1000원 미만의 금액에 대해 티켓이 잘못 반환되었습니다.");
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닐 때, 올바른 티켓 수를 반환해야 한다")
    public void calculateNumberOfTickets_WhenAmountIsNotMultipleOfOneThousand_ShouldReturnCorrectNumberOfTickets() {
        LottoTicketCalculator calculator = new LottoTicketCalculator();
        int tickets = calculator.calculateNumberOfTickets(2500);
        assertEquals(2, tickets, "1000원 단위가 아닌 금액에 대한 티켓 수가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("구매 금액이 매우 클 때, 올바르게 계산되어야 한다")
    public void calculateNumberOfTickets_WhenAmountIsVeryLarge_ShouldCalculateCorrectly() {
        LottoTicketCalculator calculator = new LottoTicketCalculator();
        int tickets = calculator.calculateNumberOfTickets(1_000_000);
        assertEquals(1000, tickets, "매우 큰 금액에 대한 티켓 수가 올바르지 않습니다.");
    }
}