package lotto.view;

public class OutputView {

    private static final String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";

    public static void printLottoPurchase() {
        System.out.print(LOTTO_PURCHASE_MESSAGE);
    }

    public static void printLottoCount() {
        System.out.print(LOTTO_COUNT_MESSAGE);
    }
}
