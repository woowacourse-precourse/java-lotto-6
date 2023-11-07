package lotto.view;

import lotto.domain.Lotto;

public class Output {
    private static final String MESSAGE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MESSAGE_WINNING_STATISTICS = "구입금액을 입력해 주세요.";
    private static final String FORMAT_PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public static void getMessageOfPurchaseLotto() {
        System.out.println(MESSAGE_PURCHASE_MONEY);
    }

    public static void getFormatOfPurchaseMessage(int lottoCount) {
        System.out.printf("\n" + FORMAT_PURCHASE_MESSAGE + "\n", lottoCount);
    }

    public static void printLottoList(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
