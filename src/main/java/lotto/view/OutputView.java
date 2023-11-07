package lotto.view;

import lotto.domain.Lotto;

public class OutputView {
    public static final String TICKET_COUNT_MSG = "개를 구매했습니다.";

    public static void printTicketCount(int lottoCount) {
        System.out.println(lottoCount + TICKET_COUNT_MSG);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

}
