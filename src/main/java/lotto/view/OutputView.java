package lotto.view;

public class OutputView {

    private static final String PURCHASE_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";

    public void printPurchaseMessage() {
        System.out.println(PURCHASE_PROMPT_MESSAGE);
    }

    public void printLottos(final int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

}
