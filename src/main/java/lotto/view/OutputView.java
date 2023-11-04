package lotto.view;

import java.util.List;
import lotto.model.Ticket;

public class OutputView {
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printNumOfTickets(int numOfTickets) {
        System.out.println("\n" + numOfTickets + "개를 구매했습니다.");
    }

    public static void printLottoTicketsInfo(List<Ticket> lottoTickets) {
        int numOfTickets = lottoTickets.size();
        printNumOfTickets(numOfTickets);
        for (Ticket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }
}
