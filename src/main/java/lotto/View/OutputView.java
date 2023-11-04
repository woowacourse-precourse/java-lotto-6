package lotto.View;

import lotto.model.Lotto;
import lotto.model.LottoTickets;

public class OutputView {

    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static void printLottoPurchaseAmountMessage() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_PURCHASE_MESSAGE);
    }

    public static void printLottoTickets(LottoTickets lottoTickets){
        for (Lotto lotto : lottoTickets.getTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
