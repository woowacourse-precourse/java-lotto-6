package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.common.utils.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {
    @DisplayName("저장된 티켓 숫자를 출력한다.")
    @Test
    void 메서드에_들어온_티켓_숫자를_정확히_출력하는_경우() {
        View view = new View();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        view.lottoTicketInformation(lottoTicket());
        System.out.flush();
        String actualPrint = byteArrayOutputStream.toString();

        lottoTicketIntegerListToStringList(lottoTicket()).forEach(ticket -> {
            assertThat(actualPrint).contains(ticket);
        });
    }

    private ArrayList<ArrayList<Integer>> lottoTicket() {
        ArrayList<ArrayList<Integer>> lottoTickets = new ArrayList<>();
        ArrayList<Integer> lottoTicket1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> lottoTicket2 = new ArrayList<>(Arrays.asList(11, 32, 36, 14, 25, 26));
        ArrayList<Integer> lottoTicket3 = new ArrayList<>(Arrays.asList(41, 23, 6, 15, 25, 9));
        lottoTickets.add(lottoTicket1);
        lottoTickets.add(lottoTicket2);
        lottoTickets.add(lottoTicket3);
        return lottoTickets;
    }

    private List<List<String>> lottoTicketIntegerListToStringList(ArrayList<ArrayList<Integer>> lottoTicket) {
        List<List<String>> lottoTicketString = new ArrayList<>();
        lottoTicket.forEach(ticket -> {
            lottoTicketString.add(Parser.integerListToStringList(ticket));
        });
        return lottoTicketString;
    }
}
