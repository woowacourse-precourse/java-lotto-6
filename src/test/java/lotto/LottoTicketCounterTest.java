package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTicketCounterTest extends NsTest {
    @DisplayName("로또가 정상적으로 발행될 경우")
    @Test
    void issueLottoTicket_test() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("4000\n".getBytes());
        System.setIn(in);

        // when/then
        assertDoesNotThrow(() -> {
            LottoTicketCounter lottoTicketCounter = new LottoTicketCounter();
            lottoTicketCounter.issueLottoTicket();
        });
    }

    @DisplayName("현재 로또 상태 출력")
    @Test
    void printLottos_test() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("4000\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when
        LottoTicketCounter lottoTicketCounter = new LottoTicketCounter();
        lottoTicketCounter.issueLottoTicket();
        lottoTicketCounter.printLottos();

        // then
        String output = outContent.toString();
        assertThat(output).contains("4개를 구매했습니다.");

        System.setIn(System.in);
        System.setOut(new PrintStream(System.out));
    }

    @Override
    protected void runMain() {Application.main(new String[]{});}
}
