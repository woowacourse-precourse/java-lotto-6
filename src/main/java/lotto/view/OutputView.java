package lotto.view;


public class OutputView {

    public static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";

    public static void printInputPrice() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
    }

    public static void printPurchaseLotto(int lottoCount) {
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE, lottoCount);
    }
}
