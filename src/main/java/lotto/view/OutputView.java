package lotto.view;

public class OutputView {
    private static final String LOTTO_PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    public void printLottoPurchaseInputMessage() {
        System.out.println(LOTTO_PURCHASE_INPUT_MESSAGE);
    }

    public void printLottoPurchaseCountMessage(int LottoPurchaseCount) {
        System.out.println(LottoPurchaseCount + LOTTO_PURCHASE_COUNT_MESSAGE);
    }
}
