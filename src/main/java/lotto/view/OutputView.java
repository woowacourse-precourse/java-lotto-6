package lotto.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다";

    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_PREFIX + exceptionMessage);
    }

    public void printPurchaseAmountMessage() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchasedNumberMessage(int number) {
        System.out.println(number + LOTTO_PURCHASE_MESSAGE);
    }

    public void printAllLottoNumbers(String allLottoNumbers) {
        System.out.println(allLottoNumbers);
    }
}
