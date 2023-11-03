package lotto.view;

public class Output {
    private final String REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public static void errorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);

    }
}
