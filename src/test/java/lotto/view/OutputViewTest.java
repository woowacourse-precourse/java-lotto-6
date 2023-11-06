package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.parser.Parser;
import lotto.util.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @DisplayName("로또 번호 목록을 출력한다.")
    @Test
    void printLotto() {
        int ticketAmount = Parser.parsePurchaseAmount("8000");
        List<Lotto> tickets = Generator.publishTickets(ticketAmount);

        OutputView.responseTickets(ticketAmount, tickets);
    }
}
