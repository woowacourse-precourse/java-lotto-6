package lotto.view;

public class OutputView {
    private static final String LOTTO_PURCHASE_COMMENT = "구입금액을 입력해 주세요.";

    public void printLottoPurchaseComment() {
        System.out.println(LOTTO_PURCHASE_COMMENT);
    }

    public void printLineSeparator() {
        System.out.println();
    }

    public void printLottoCountMessage(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }
}
