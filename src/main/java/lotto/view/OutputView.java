package lotto.view;

import lotto.model.Lottos;

public class OutputView {
    public static final String PURCHASE_MSG = "개를 구매했습니다.";

    public void printLottoTicketCount(int TicketCount) {
        System.out.println(TicketCount + PURCHASE_MSG);

    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());

    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
