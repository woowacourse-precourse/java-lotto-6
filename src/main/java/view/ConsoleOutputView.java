package view;

public class ConsoleOutputView implements OutputView {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    @Override
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
    }
}
