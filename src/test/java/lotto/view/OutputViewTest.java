package lotto.view;

import static lotto.view.OutputView.printLottoTickets;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
        Console.close();
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 발행된_티켓들은_오름차순으로_출력되어야_한다() {
        final LottoTickets tickets = new LottoTickets(
            List.of(
                new Lotto(List.of(1, 3, 5, 7, 9, 11)),
                new Lotto(List.of(1, 7, 5, 6, 21, 11))
            )
        );

        printLottoTickets(tickets);

        assertThat(output()).contains(String.format("%d개를 구매했습니다.", 2));
        assertThat(output()).contains("[1, 3, 5, 7, 9, 11]");
        assertThat(output()).contains("[1, 5, 6, 7, 11, 21]");
    }

}