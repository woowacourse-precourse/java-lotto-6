package lotto.view;

import lotto.model.LottoTicket;

public class OutputView {
    private final static String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchaseAmount(Integer amount) {
        System.out.println("\n" + amount + PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.toString());
    }

}
