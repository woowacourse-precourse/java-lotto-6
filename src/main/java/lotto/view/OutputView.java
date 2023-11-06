package lotto.view;

public class OutputView {
    private static final String LOTTO_START_MESSAGE = "구입금액을 입력해 주세요.";

    public void askForPurchaseAmount() {
        System.out.println(LOTTO_START_MESSAGE);
    }
}
