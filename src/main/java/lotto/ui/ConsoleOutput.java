package lotto.ui;

public class ConsoleOutput implements Output {
    private static final String LOTTO_PRICE_REQUEST = "구입금액을 입력해 주세요.";

    public void printLottoPriceRequest() {
        System.out.println(LOTTO_PRICE_REQUEST);
    }
}
