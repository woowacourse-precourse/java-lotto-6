package lotto.view;

public class OutputView {

    private static final String PAYMENT_GUIDE = "구입금액을 입력해 주세요.";

    private OutputView() {
    }

    public static void printPaymentGuide() {
        System.out.println(PAYMENT_GUIDE);
    }

}
