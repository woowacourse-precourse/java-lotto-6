package lotto.view;

public class InputView {
    private final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final String PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";

    public void purchaseAmountView(){
        System.out.println(PURCHASE_AMOUNT);
    }

    public void prizeNumber(){
        System.out.println("\n" + PRIZE_NUMBER);
    }

}
