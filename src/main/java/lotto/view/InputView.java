package lotto.view;

public class InputView {
    private static final String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public void requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE);
    }

    public void requestWinningNum() {
        System.out.println(REQUEST_WINNING_NUM);
    }

    public void requestBonusNum() {
        System.out.println(REQUEST_BONUS_NUM);
    }
}
