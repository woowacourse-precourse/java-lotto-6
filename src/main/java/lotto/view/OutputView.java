package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    //    private static final String TICKET_COUNT_MESSAGE ="개를 구매했습니다.";
    private static final String TICKET_COUNT_MESSAGE = "you buy";

    public static void displayTicket_Count(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + TICKET_COUNT_MESSAGE);
    }

    public static void displayLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
