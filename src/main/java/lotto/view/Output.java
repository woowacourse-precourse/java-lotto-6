package lotto.view;

import lotto.domain.Buyer;
import lotto.domain.Lotto;

public class Output {
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTO_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void printAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printPurchasedLottos(Buyer buyer) {
        System.out.println(buyer.getLottos().size() + PURCHASED_LOTTO_MESSAGE);

        for (Lotto lotto : buyer.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningNumberMessage() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
