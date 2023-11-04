package lotto;

import lotto.constants.InputMessage;

public class LottoView {
    public static void printLottoTicketCount(int count) {
        System.out.println();
        System.out.println(count + InputMessage.LOTTO_TICKET_COUNT.getMessage());
    }
}
