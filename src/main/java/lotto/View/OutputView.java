package lotto.View;

import lotto.model.Lotto;
import lotto.model.LottoTickets;

public class OutputView {

    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER_WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";

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

    public static void printEnterWinningNumber() {
        System.out.println(ENTER_WINNING_MESSAGE);
    }
}
