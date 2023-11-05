package lotto.view;

import lotto.common.Constant;
import lotto.model.LottoTickets;

public class OutputView {

    private static final String OUTPUT_LOTTO_NUMBER = "개를 구매했습니다.";

    public static void printLottoCount(LottoTickets lottoTickets) {
        System.out.println(Constant.LINE.getCharValue() + lottoTickets.getTickets().size() + OUTPUT_LOTTO_NUMBER);
    }

    public static void printLottoList(LottoTickets lottoTickets) {
        printLottoCount(lottoTickets);
        lottoTickets.getTickets().forEach(ticket -> System.out.println(ticket.toString()));
    }

}
